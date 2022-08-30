package com.carwash.washer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.washer.models.Washer;
import com.carwash.washer.services.WasherService;

@RestController
@RequestMapping("/washer")
public class WasherController {
	@Autowired
	private WasherService service;
	
	@GetMapping("/getall")
	public List<Washer> getWasher(){
		return service.getWasher();
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> insertWasher(@RequestBody Washer washer) {
		System.out.println("Washer registered");
		service.addWasher(washer);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/deletewasher/{emailId}")
	public ResponseEntity<String> deleteWasherById(@PathVariable("emailId")String emailId){
		service.deleteWasher(emailId);
		return new ResponseEntity<String>("Delete-successfully",HttpStatus.OK);
	}
}
