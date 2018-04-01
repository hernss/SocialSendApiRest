package com._37coins.bcJsonRpc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VerifyResult {
/*
 * {
    "isvalid" : true,
    "address" : "SSPLKY3YZHpXxQrjBSYU3vXkUucPDgJhN8",
    "ismine" : false
}

 */
	
	private boolean isvalid;
	private String address;
	private boolean ismine;
	
	public boolean isIsvalid() {
		return isvalid;
	}
	public void setIsvalid(boolean isvalid) {
		this.isvalid = isvalid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isIsmine() {
		return ismine;
	}
	public void setIsmine(boolean ismine) {
		this.ismine = ismine;
	}
}
