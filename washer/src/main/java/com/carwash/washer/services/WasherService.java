package com.carwash.washer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.carwash.washer.models.Washer;
import com.carwash.washer.repositories.WasherRepository;

@Service
public class WasherService {
	@Autowired
	private WasherRepository repository;
	
	public boolean Dcrypto(String n,String o)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		return encoder.matches(n, o);  
	
	}
	
	public Boolean check(String password,String emailId)
	{
		Optional<Washer> wash=repository.findById(emailId);
		Washer p=wash.get();
		boolean ret=false;
		if(Dcrypto(password,p.getPassword()))
		{
			ret=true;
		}
		return ret;
	}
	public Washer addWasher(Washer washer) {
		return repository.save(washer);
	}
	
	public List<Washer> getWasher() {
		List<Washer> washer = repository.findAll();
		System.out.println("Getting data from DB : " + washer);
		return washer;
	}
	public void updateWasher(String emailId, Washer user) {
		List<Washer> users = repository.findAll();
		for(int i=0;i<users.size();i++) {
			Washer u = users.get(i);
			if(u.getEmailId().equals(emailId)) {
				users.set(i, user);
				 repository.save(user);
			}
			
		}
	}
	
	public void deleteWasher(String emailId) {
		repository.deleteById(emailId);
	}
	public Optional<Washer> getByUserEmail(String emailId) {
		return repository.findById(emailId);
	}
}
