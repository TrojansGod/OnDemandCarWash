package com.carwash.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.user.models.Customer;
import com.carwash.user.repositories.UserRepository;

@Service
public class UserService{

	
	@Autowired
	private UserRepository repository;
	
	public Customer addUser(Customer user) {
		return repository.save(user);
	}
	
	public List<Customer> getUsers() {
		List<Customer> users = repository.findAll();
		System.out.println("Getting data from DB : " + users);
		return users;
	}
	
	public void deleteUser(String emailId) {
		repository.deleteById(emailId);
	}
	
	public void updateUser(String emailId, Customer user) {
		List<Customer> users = repository.findAll();
		for(int i=0;i<users.size();i++) {
			Customer u = users.get(i);
			if(u.getEmailId().equals(emailId)) {
				user.setRole(u.getRole());
				users.set(i, user);
				repository.save(user);
			}
		}
	}
	
	public Optional<Customer> getByUserEmail(String emailId) {
		return repository.findByEmail(emailId);
	}
	
}
