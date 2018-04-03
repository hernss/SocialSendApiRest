package com._37coins.bcJsonRpc.pojo;

import java.math.BigDecimal;

public class TxInfo {

	private String to;
	private String from;
	private long time;
	private double amount;
	private BigDecimal confirmations;
	private boolean isReward;
	private String date;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public BigDecimal getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(BigDecimal confirmations) {
		this.confirmations = confirmations;
	}
	public boolean isReward() {
		return isReward;
	}
	public void setReward(boolean isReward) {
		this.isReward = isReward;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
