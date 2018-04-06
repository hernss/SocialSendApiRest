package com._37coins.bcJsonRpc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VerifyResult {
/*
 * {
    "isvalid" : true,
    "address" : "ST9kcRxsq4JcQVaYfV69Z1uMKzhKzmyFV4",
    "ismine" : true,
    "iswatchonly" : false,
    "isscript" : false,
    "pubkey" : "0314023cd5d8a7a86a0e5b185a2ad876b30a043711d3b78f692f6d911a4082cd8b",
    "iscompressed" : true,
    "account" : "0"
}


 */
	
	private boolean isvalid;
	private String address;
	private boolean ismine;
	private boolean iswatchonly;
	private boolean isscript;
	private String pubkey;
	private boolean iscompressed;
	private String account;
	
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
	public boolean isIswatchonly() {
		return iswatchonly;
	}
	public void setIswatchonly(boolean iswatchonly) {
		this.iswatchonly = iswatchonly;
	}
	public boolean isIsscript() {
		return isscript;
	}
	public void setIsscript(boolean isscript) {
		this.isscript = isscript;
	}
	public String getPubkey() {
		return pubkey;
	}
	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}
	public boolean isIscompressed() {
		return iscompressed;
	}
	public void setIscompressed(boolean iscompressed) {
		this.iscompressed = iscompressed;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
