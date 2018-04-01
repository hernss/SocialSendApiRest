package com._37coins.bcJsonRpc.pojo;

public class Masternode {
/*
 * {
        "rank" : 778,
        "txhash" : "9a21f4832bcc10b21fb6d62f5c28538e6c41f426b8f99d1578e4a0eeba9de09e",
        "outidx" : 1,
        "status" : "ENABLED",
        "addr" : "SVJ38op1KzTg2G5YzR9rnApKD6VqFiSKg7",
        "version" : 70810,
        "lastseen" : 1522544026,
        "activetime" : 590325,
        "lastpaid" : 1522537059
    },

 */
	
	private long rank;
	private String txhash;
	private long outidx;
	private String status;
	private String addr;
	private long version;
	private long lastseen;
	private long activetime;
	private long lastpaid;
	
	public long getRank() {
		return rank;
	}
	public void setRank(long rank) {
		this.rank = rank;
	}
	public String getTxhash() {
		return txhash;
	}
	public void setTxhash(String txhash) {
		this.txhash = txhash;
	}
	public long getOutidx() {
		return outidx;
	}
	public void setOutidx(long outidx) {
		this.outidx = outidx;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getLastseen() {
		return lastseen;
	}
	public void setLastseen(long lastseen) {
		this.lastseen = lastseen;
	}
	public long getActivetime() {
		return activetime;
	}
	public void setActivetime(long activetime) {
		this.activetime = activetime;
	}
	public long getLastpaid() {
		return lastpaid;
	}
	public void setLastpaid(long lastpaid) {
		this.lastpaid = lastpaid;
	}
}
