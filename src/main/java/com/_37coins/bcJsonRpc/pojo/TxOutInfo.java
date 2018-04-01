package com._37coins.bcJsonRpc.pojo;

import java.math.BigDecimal;

public class TxOutInfo {
/*
 * gettxoutsetinfo
{
    "height" : 188274,
    "bestblock" : "5f9f93d0506602126dfad8b608f877e92e165225901c2643f3d8a5dc1060bb15",
    "transactions" : 390787,
    "txouts" : 490720,
    "bytes_serialized" : 18199930,
    "hash_serialized" : "f74ca832180edac5f412ca23cca9179464e80d69dadefd122f9d81eec45421ec",
    "total_amount" : 34888891.53841301
}

 */
	
	private BigDecimal height;
	private String bestblock;
	private BigDecimal transactions;
	private BigDecimal txouts;
	private BigDecimal bytes_serialized;
	private String hash_serialized;
	private double total_amount;
	
	public double getTotalSupply() {
		return total_amount;
	}
	
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public String getBestblock() {
		return bestblock;
	}
	public void setBestblock(String bestblock) {
		this.bestblock = bestblock;
	}
	public BigDecimal getTransactions() {
		return transactions;
	}
	public void setTransactions(BigDecimal transactions) {
		this.transactions = transactions;
	}
	public BigDecimal getTxouts() {
		return txouts;
	}
	public void setTxouts(BigDecimal txouts) {
		this.txouts = txouts;
	}
	public BigDecimal getBytes_serialized() {
		return bytes_serialized;
	}
	public void setBytes_serialized(BigDecimal bytes_serialized) {
		this.bytes_serialized = bytes_serialized;
	}
	public String getHash_serialized() {
		return hash_serialized;
	}
	public void setHash_serialized(String hash_serialized) {
		this.hash_serialized = hash_serialized;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	
	
}
