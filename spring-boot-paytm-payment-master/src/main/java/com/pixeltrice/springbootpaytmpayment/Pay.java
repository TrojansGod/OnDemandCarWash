package com.pixeltrice.springbootpaytmpayment;


public class Pay {
	
	private String orderId;

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