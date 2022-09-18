package com.carwash.washer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.carwash.washer.models.Washer;
import com.carwash.washer.services.WasherService;

@RestController
@RequestMapping("/washer")
@CrossOrigin()
public class WasherController {
	@Autowired
	private WasherService service;
	
	public String crypto(String n)
	{
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(
            12);
            // 12 is the strength here 
	String encodedPassword = encoder.encode(n);
	return encodedPassword;
	
	}
	
	@GetMapping("/getall")
	public List<Washer> getWasher(){
		return service.getWasher();
	}
	@GetMapping("/getpass/{emailId}")
	public Boolean pass(@RequestBody String password,@PathVariable String emailId) 
	{		
		return service.check(emailId,password);
		
	}

	@PostMapping("/register")
	public ResponseEntity<String> insertWasher(@RequestBody Washer washer) {
		System.out.println("Washer registered");
		String j= crypto(washer.getPassword());
		washer.setPassword(j);
		service.addWasher(washer);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	@PutMapping("/update/{emailId}")
	public ResponseEntity<String> updateWasher(@RequestBody Washer washer,@PathVariable("emailId") String emailId) {
		System.out.println("Washer registered");
		String j= crypto(washer.getPassword());
		washer.setPassword(j);
		service.updateWasher(emailId,washer);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/deletewasher/{emailId}")
	public ResponseEntity<String> deleteWasherById(@PathVariable("emailId")String emailId){
		service.deleteWasher(emailId);
		return new ResponseEntity<String>("Delete-successfully",HttpStatus.OK);
	}
	@GetMapping({"/getemail/{emailId}"})
	public Optional<Washer> getByEmailUser(@PathVariable("emailId") String emailId) {
		return service.getByUserEmail(emailId);
	}
}
