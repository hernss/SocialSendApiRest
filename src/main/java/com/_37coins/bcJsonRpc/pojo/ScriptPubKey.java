package com._37coins.bcJsonRpc.pojo;

public class ScriptPubKey {
/*
 * "scriptPubKey" : {
                "asm" : "",
                "hex" : "",
                "type" : "nonstandard"
            }
 */
	
	private String asm;
	private String hex;
	private String type;
	
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
}
