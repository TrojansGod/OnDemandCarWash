package com.carwash.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {
	
	@Id
	String role;
	String discription;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Role(String role, String discription) {
		super();
		this.role = role;
		
		this.discription = discription;
	}
	
	public Role()
	{
		super();
	}

}
