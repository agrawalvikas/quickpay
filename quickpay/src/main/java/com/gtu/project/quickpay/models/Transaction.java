package com.gtu.project.quickpay.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {
	private long transactionId;
	private long senderId;
	private long receiverId;
	private int ammount;
	private String date;
	private String tranStatus;
	
	public Transaction(long senderId, long receiverId,
			int ammount) {
		super();
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyddHHmmss format it as per your requirement
		this.date = dateFormat.format(currentDate.getTime());	
		SimpleDateFormat tranID= new SimpleDateFormat("mmss"); // yyddHHmmss format it as per your requirement
		String transIDFormat = tranID.format(currentDate.getTime());
		this.transactionId = Long.parseLong(transIDFormat);
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.ammount = ammount;
		 
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getSenderId() {
		return senderId;
	}
	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}
	public long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTranStatus() {
		return tranStatus;
	}
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
	
}
