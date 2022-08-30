package com.carwash.washer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.washer.models.Washer;
import com.carwash.washer.repositories.WasherRepository;

@Service
public class WasherService {
	@Autowired
	private WasherRepository repository;
	
	public Washer addWasher(Washer washer) {
		return repository.save(washer);
	}
	
	public List<Washer> getWasher() {
		List<Washer> washer = repository.findAll();
		System.out.println("Getting data from DB : " + washer);
		return washer;
	}
	
	public void deleteWasher(String emailId) {
		repository.deleteById(emailId);
	}
}
