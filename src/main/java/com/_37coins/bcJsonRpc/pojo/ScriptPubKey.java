package com._37coins.bcJsonRpc.pojo;

import java.util.List;

public class ScriptPubKey {
/*
 * "scriptPubKey" : {
                "asm" : "",
                "hex" : "",
                "type" : "nonstandard"
            }
 */
	
	/*
	 * "scriptPubKey" : {
                "asm" : "OP_DUP OP_HASH160 434eedde15fb628a918ebbade9941e09c66832c4 OP_EQUALVERIFY OP_CHECKSIG",
                "hex" : "76a914434eedde15fb628a918ebbade9941e09c66832c488ac",
                "reqSigs" : 1,
                "type" : "pubkeyhash",
                "addresses" : [
                    "STRtrnjav8MGfTrkUn1BgMwdCU9mwYCQff"
                ]
            }
	 */
	
	private String asm;
	private String hex;
	private String type;
	private long reqSigs;
	private List<String> addresses;
	
	public String getAsm() {
		return asm;
	}
	public void setAsm(String asm) {
		this.asm = asm;
	}
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getReqSigs() {
		return reqSigs;
	}
	public void setReqSigs(long reqSigs) {
		this.reqSigs = reqSigs;
	}
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
}
