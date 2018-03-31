package com._37coins.bcJsonRpc.pojo;

import java.util.List;

public class BlockHeader {
	 /* "version" : 3,
	    "previousblockhash" : "00000caf2665cc6b296b5ca721d7d43a5f5ae748cfe577d2fb7c102f1c7d08ca",
	    "merkleroot" : "4f72eb7995dc470f52e38dbc034b72d6d05eaf12d73c91dea038dcd5639e87f5",
	    "time" : 1510940463,
	    "bits" : "1e0fffff",
	    "nonce" : 753386
	*/
	
	private long time;
	private long nonce;
	private String bits;
	private String merkleroot;
	private String previousblockhash;
	private long version;
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getNonce() {
		return nonce;
	}
	public void setNonce(long nonce) {
		this.nonce = nonce;
	}
	public String getBits() {
		return bits;
	}
	public void setBits(String bits) {
		this.bits = bits;
	}
	public String getMerkleroot() {
		return merkleroot;
	}
	public void setMerkleroot(String merkleroot) {
		this.merkleroot = merkleroot;
	}
	public String getPreviousblockhash() {
		return previousblockhash;
	}
	public void setPreviousblockhash(String previousblockhash) {
		this.previousblockhash = previousblockhash;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	
	
}
