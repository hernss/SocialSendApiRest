package com._37coins.bcJsonRpc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class NewPaymentParameters {
/*
 * 	emailSender
	emailReceiver
	depositAddress
	amount
	minimiumConfirmations : default 3
	expire : default 7200 segundos
 */
	
	private String emailSender;
	private String emailReceiver;
	private String depositAddress;
	private double amount;
	private long minimiumConfirmations = 3;
	private long expire = 7200;
	
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
}
