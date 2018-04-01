package com._37coins.bcJsonRpc.pojo;

public class TransactionDetail {
/*
 * {
        "account" : "",
        "address" : "ST7brMpLSMGhfW5viES8oXzZKnHdKLM3tA",
        "category" : "send",
        "amount" : -3134.75000000,
        "vout" : 1,
        "fee" : 11.99998519
    },
 */
	private String account;
	private String address;
	private String category;
	private double amount;
	private long vout;
	private double fee;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getVout() {
		return vout;
	}
	public void setVout(long vout) {
		this.vout = vout;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
}
