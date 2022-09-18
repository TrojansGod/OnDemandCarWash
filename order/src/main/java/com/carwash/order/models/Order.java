package com.carwash.order.models;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {
	@Id
	private String orderId;
	@Field
	private String washerId;
	@Field
	private String emailId;
	@Field
	private String firstName;
	@Field
	private String lastname;
	@Field
	private String timeDate;
	@Field
	private String washerName;
	@Field
	private String washerLocation;
	@Field
	private String pack;
	@Field
	private String cost;
	@Field
	private String success;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getWasherId() {
		return washerId;
	}
	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getWasherLocation() {
		return washerLocation;
	}
	public void setWasherLocation(String washerLocation) {
		this.washerLocation = washerLocation;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Order(String orderId, String washerId, String emailId, String firstName, String lastname, String timeDate,
			String washerName, String washerLocation, String pack, String cost, String success) {
		super();
		this.orderId = orderId;
		this.washerId = washerId;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.timeDate = timeDate;
		this.washerName = washerName;
		this.washerLocation = washerLocation;
		this.pack = pack;
		this.cost = cost;
		this.success = success;
	}
	
	

	}
