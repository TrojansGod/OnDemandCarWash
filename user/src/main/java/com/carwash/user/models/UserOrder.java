package com.carwash.user.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class UserOrder {
	@Field
	private String firstName;
	@Field
	private String lastName;
	@Field
	private String emailId;
	@Field
	private String location;
	@Field
	private String password;
	@Field
	private String car;
	@Id
	private String orderId;
	@Field
	private String orderDate;
	public UserOrder(String firstName, String lastName, String emailId, String location, String password, String car,
			String orderId, String orderDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.location = location;
		this.password = password;
		this.car = car;
		this.orderId = orderId;
		this.orderDate = orderDate;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Combined [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", location="
				+ location + ", password=" + password + ", car=" + car + ", orderId=" + orderId + ", orderDate="
				+ orderDate + "]";
	}
	
}
