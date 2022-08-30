package com.carwash.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Customer {
	@Id
	@Field
	private String emailId;
	@Field
	private String firstName;
	@Field
	private String lastName;
	@Field
	private String location;
	@Field
	private String password;
	@Field
	private String car;
	
	public Customer() {
		super();
	}
	public Customer(String emailId, String firstName, String lastName, String location, String password,
			String car) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.location = location;
		this.password = password;
		this.car = car;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return String.format("User[firstName='%s', lastName='%s', emailId='%s', location='%s']",firstName,lastName,emailId,location);
	}
	
	
	
}
