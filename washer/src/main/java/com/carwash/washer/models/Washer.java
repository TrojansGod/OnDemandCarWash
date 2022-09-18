package com.carwash.washer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Washer {
	@Id
	private String emailId;
	@Field
	private String washerName;
	@Field
	private String line1;
	@Field
	private String city;
	@Field
	private String state;
	@Field
	private String pincode;
	@Field
	private String landmark;
	@Field
	private long phoneNo;
	@Field
	private String password;
	
	
	
	public Washer( String emailId, String washerName, String line1, String city, String state,
			String pincode, String landmark, long phoneNo, String password) {
		super();
		this.emailId = emailId;
		this.washerName = washerName;
		this.line1 = line1;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.password = password;
		
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	@Override
	public String toString() {
		return "Washer [emailId=" + emailId + ", washerName=" + washerName + ", line1="
				+ line1 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", landmark=" + landmark
				+ ", phoneNo=" + phoneNo + ", password=" + password + "]";
	}

	
	
	
	
}
