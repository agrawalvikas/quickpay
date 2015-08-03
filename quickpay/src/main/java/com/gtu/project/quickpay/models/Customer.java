package com.gtu.project.quickpay.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	private long customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String address;
	private int pincode;
	private long phone;
	private String email;
	private long accountId;
	
	
	public Customer() {
	}
	
	public Customer( String firstName, String middleName,
			String lastName, String gender, String address,int pincode, long phone,
			String email, long accountId) {
		super();
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		SimpleDateFormat formatter= new SimpleDateFormat("HHmmssSS"); // ddHHmmssSS format it as per your requirement
		String dateNow = formatter.format(currentDate.getTime());
		this.customerId = Long.parseLong(dateNow);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.pincode = pincode;
		this.phone = phone;
		this.email = email;
		this.accountId = accountId;
	}
	
	public Customer(long customerId, String firstName, String middleName,
			String lastName, String gender, String address, int pincode, long phone,
			String email, long accountId) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.pincode = pincode;
		this.phone = phone;
		this.email = email;
		this.accountId = accountId;
	}


	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
}
