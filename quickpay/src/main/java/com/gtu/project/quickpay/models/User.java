package com.gtu.project.quickpay.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private long userId;
	private long customerId;
	private String password;
		
	public User() {
	}
	
	public User(long customerId, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
