package com.carwash.admin.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.admin.repositories.FeedbackRepository;
import com.carwash.admin.models.Feedback;


@RestController
@RequestMapping("/feedback")

public class FeedbackController {
	
	@Autowired
	private FeedbackRepository service;
	
	@PostMapping("/feed")
	public ResponseEntity<String> giveFeedback(@RequestBody Feedback feedback) {
		feedback.setFeedbackId(UUID.randomUUID().toString());
		System.out.println("Feedback stored");
		service.save(feedback);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	@GetMapping("/get")
	public List<Feedback> get(@RequestBody Feedback feedback) {
		return service.findAll();
		
	}
	
	
}
