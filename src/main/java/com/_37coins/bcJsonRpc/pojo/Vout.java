package com._37coins.bcJsonRpc.pojo;

public class Vout {
/*
  "vout" : [
        {
            "value" : 0.00000000,
            "n" : 0,
            "scriptPubKey" : {
                "asm" : "",
                "hex" : "",
                "type" : "nonstandard"
            }
        }
    ]
 */
	
	private double value;
	private long n;
	private ScriptPubKey scriptPubKey;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public long getN() {
		return n;
	}
	public void setN(long n) {
		this.n = n;
	}
	public ScriptPubKey getScriptPubKey() {
		return scriptPubKey;
	}
	public void setScriptPubKey(ScriptPubKey scriptPubKey) {
		this.scriptPubKey = scriptPubKey;
	}
}
