package com.carwash.order.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Pay {

	@Id
	@Field
	private String orderId;
	@Field
	private String Success;
	public Pay(String orderId, String success) {
		super();
		this.orderId = orderId;
		Success = success;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		Success = success;
	}
	
	
}
