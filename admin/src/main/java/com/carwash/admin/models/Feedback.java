package com.carwash.admin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Feedback {
	@Id
	@Field
	private String feedbackId;
	@Field
	private String name;
	@Field
	private String emailId;
	@Field
	private String message;
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Feedback(String feedbackId, String name, String emailId, String message) {
		super();
		this.feedbackId = feedbackId;
		this.name = name;
		this.emailId = emailId;
		this.message = message;
	}

}
