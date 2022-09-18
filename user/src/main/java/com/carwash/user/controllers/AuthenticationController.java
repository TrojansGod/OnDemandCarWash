package com.carwash.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.carwash.user.models.*;
import com.carwash.user.config.*;
import com.carwash.user.services.*;

@RestController
@CrossOrigin()
public class AuthenticationController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenClass jwtTokenUtil;

	@Autowired
	private AuthService userDetailsService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Request authenticationRequest) throws Exception {
		System.out.println("I AM HERE");
		System.out.println(authenticationRequest.getUsername()+ authenticationRequest.getPassword());
		userDetailsService.auth(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new Response(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("I AM AUTHHH");
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
