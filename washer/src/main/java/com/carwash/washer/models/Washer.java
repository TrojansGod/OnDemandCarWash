package com.carwash.washer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Washer {
	@Id
	@Field
	private String washerId;
	@Field
	private String emailId;
	@Field
	private String washerName;
	@Field
	private String location;
	@Field
	private String description;
	@Field
	private long phoneNo;
	@Field
	private String password;
	
	public Washer(String washerId, String emailId, String washerName, String location, String description, long phoneNo,
			String password) {
		super();
		this.washerId = washerId;
		this.emailId = emailId;
		this.washerName = washerName;
		this.location = location;
		this.description = description;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public String getWasherId() {
		return washerId;
	}

	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getWasherName() {
		return washerName;
	}



	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("User[WasherName='%s', Location='%s', emailId='%s', Description='%s', Phone No.='%lu']",washerName,location,emailId,description,phoneNo);
	}
	
	
	
}
