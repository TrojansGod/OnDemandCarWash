package com.carwash.user.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.carwash.user.controllers.UserController;
import com.carwash.user.models.Customer;
import com.carwash.user.repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
	@Autowired
	private UserController controller;
	
	@Autowired 
	private UserRepository repo;
	

	static String  password="default";
	static String user="default";
	
	static Set authorities=new HashSet();
	public static boolean Dcrypto(String n,String o)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		return encoder.matches(n, o);  
		
	
	}
	public void auth(String a, String b) throws InterruptedException
	{
		List<Customer> k=  repo.getemailById(a);
		//UserCarDetails p = new UserCarDetails();
		for(Customer t:k)
		{
			if(Dcrypto(b,t.getPassword()))
				{password=t.getPassword();
				user=t.getEmailId();
				authorities.clear();
				authorities.add(new SimpleGrantedAuthority("ROLE_"+t.getRole()));
				break;
				}
			
			System.out.println(user+password);
		}
		System.out.println(user+password);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("username"))
		{
			return new User("username","$2a$12$vW3JUxIwIe2epnIQDUJOL.FFcwgRgnBb2RK.AXKppapGr0A99c1hW",
					new ArrayList<>());
			
		}
		else if (user.equals(username)) {
			return new org.springframework.security.core.userdetails.User(user,password,authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}