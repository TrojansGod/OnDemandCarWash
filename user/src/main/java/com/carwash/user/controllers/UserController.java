package com.carwash.user.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import com.carwash.user.models.Washer;

import com.carwash.user.models.Customer;
import com.carwash.user.repositories.UserRepository;
import com.carwash.user.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repo;
	
	public boolean Dcrypto(String n,String o)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		return encoder.matches(n, o);  
	
	}
	public String crypto(String n)
	{
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(
            12);
            // 12 is the strength here 
	String encodedPassword = encoder.encode(n);
	return encodedPassword;
	
	}
	
	
	@GetMapping({"/getall"})
	@PreAuthorize("hasRole('admin')")
	public List<Customer> getUsers(){
		return service.getUsers();
	}
	
	@PostMapping({"/register"})
	public ResponseEntity<String> insertUser(@RequestBody Customer customer) {
		System.out.println("User registered");
		String j= crypto(customer.getPassword());
		customer.setPassword(j);
		customer.setRole("user");
		service.addUser(customer);
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	@PostMapping({"/register/admin"})
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<String> insertUserAdmin(@RequestBody Customer customer) {
		System.out.println("User registered");
		String j= crypto(customer.getPassword());
		customer.setPassword(j);
		customer.setRole("admin");
		service.addUser(customer);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping({"/deleteuser/{emailId}"})
	@PreAuthorize("hasAnyRole('admin','user')")
	public ResponseEntity<String> deleteUserById(@PathVariable("emailId")String emailId){
		service.deleteUser(emailId);
		return new ResponseEntity<String>("Delete-successfully",HttpStatus.OK);
	}
	
	@PutMapping({"/updateuser/{emailId}"})
	@PreAuthorize("hasAnyRole('admin','user')")
	public void updateUser(@RequestBody Customer customer,@PathVariable String emailId) {
		service.updateUser(emailId, customer);
	}
	
	@GetMapping({"/getemail/{emailId}"})
	@PreAuthorize("hasAnyRole('admin','user')")
	public Optional<Customer> getByEmailUser(@PathVariable("emailId") String emailId) {
		return service.getByUserEmail(emailId);
	}
	
	
	@PostMapping({"/washer"})
	@PreAuthorize("hasRole('admin')")
	public String fullWasher(@RequestBody Washer wash) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:8082/washer/register/",wash,String.class);
		
	}
	@PutMapping({"/updatewasher/{emailId}"})
	@PreAuthorize("hasRole('admin')")
	public void Washerupdate(@RequestBody Washer wash,@PathVariable String emailId) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8082/washer/update/"+emailId,wash);
		
	}
	@DeleteMapping({"/deletewasher/{emailId}"})
	@PreAuthorize("hasRole('admin')")
	public void Deleteupdate(@PathVariable String emailId) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8082/washer/deletewasher/"+emailId);
		
	}
	
	}
