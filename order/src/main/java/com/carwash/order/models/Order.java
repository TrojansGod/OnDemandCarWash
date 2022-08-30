package com.carwash.order.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {
	@Id
	@Field
	private String orderId;
	@Field
	private String emailId;
	@Field
	private String orderDate;
	@Field
	private String location;
	
	
	public Order(String orderId, String emailId, String orderDate, String location) {
		super();
		this.orderId = orderId;
		this.emailId = emailId;
		this.orderDate = orderDate;
		this.location = location;
		
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
