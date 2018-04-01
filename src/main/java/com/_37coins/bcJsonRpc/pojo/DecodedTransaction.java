package com._37coins.bcJsonRpc.pojo;

import java.util.List;

public class DecodedTransaction {
	/*
	"txid" : "ea5eaee9c9a74e5e43f65e51b39bcc1684dc0b9617993bdc5567d9acbadefe59",
    "version" : 1,
    "locktime" : 0,
    "vin" : [
        {
            "coinbase" : "039cd9020101",
            "sequence" : 4294967295
        }
    ],
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
	
	
	
	
	private String txid;
	private long version;
	private long locktime;
	private List<Vin> vin;
	private List<Vout> vout;
	
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getLocktime() {
		return locktime;
	}
	public void setLocktime(long locktime) {
		this.locktime = locktime;
	}
	public List<Vin> getVin() {
		return vin;
	}
	public void setVin(List<Vin> vin) {
		this.vin = vin;
	}
	public List<Vout> getVout() {
		return vout;
	}
	public void setVout(List<Vout> vout) {
		this.vout = vout;
	}
}

