package com.gtu.project.quickpay.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	private long accountId;
	private int balance;
	private int pin;
	private String cardId;
	
	
	public Account(int balance, int pin, String cardId) {
		super();
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		SimpleDateFormat formatter= new SimpleDateFormat("yyddHHmmss"); // yyddHHmmss format it as per your requirement
		String dateNow = formatter.format(currentDate.getTime());
		this.accountId = Long.parseLong(dateNow);
		this.balance = balance;
		this.pin = pin;
		this.cardId = cardId;
	}
	
	public Account(long accountId,int balance, int pin, String cardId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.pin = pin;
		this.cardId = cardId;
	}
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
}
