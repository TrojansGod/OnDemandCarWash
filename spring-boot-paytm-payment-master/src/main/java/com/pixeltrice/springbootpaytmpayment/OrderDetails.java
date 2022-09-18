package com.pixeltrice.springbootpaytmpayment;


public class OrderDetails {
	
	private String orderId;

	private String washerId;

	private String emailId;

	private String firstName;
	
	private String lastname;
	
	private String timeDate;

	private String washerName;
	
	private String washerLocation;

	private String pack;
	
	private String cost;

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
	public OrderDetails(String orderId, String washerId, String emailId, String firstName, String lastname, String timeDate,
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
