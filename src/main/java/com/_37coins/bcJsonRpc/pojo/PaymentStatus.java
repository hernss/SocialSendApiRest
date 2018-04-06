package com._37coins.bcJsonRpc.pojo;

public class PaymentStatus {

	private long id;
	private String emailSender;
	private String emailReceiver;
	private String depositAddress;
	private double amount;
	private long minimiumConfirmations;
	private long expire;
	private String status;
	
	public String getEmailSender() {
		return emailSender;
	}
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}
	public String getEmailReceiver() {
		return emailReceiver;
	}
	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}
	public String getDepositAddress() {
		return depositAddress;
	}
	public void setDepositAddress(String depositAddress) {
		this.depositAddress = depositAddress;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getMinimiumConfirmations() {
		return minimiumConfirmations;
	}
	public void setMinimiumConfirmations(long minimiumConfirmations) {
		this.minimiumConfirmations = minimiumConfirmations;
	}
	public long getExpire() {
		return expire;
	}
	public void setExpire(long expire) {
		this.expire = expire;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
