package com._37coins.bcJsonRpc.pojo;

import java.math.BigDecimal;

public class Vin {
	/*"vin" : [
	         {
	             "coinbase" : "039cd9020101",
	             "sequence" : 4294967295
	         }
	     ],
	     */
	
	public String coinbase;
	public BigDecimal sequence;
	
	public String getCoinbase() {
		return coinbase;
	}
	public void setCoinbase(String coinbase) {
		this.coinbase = coinbase;
	}
	public BigDecimal getSequence() {
		return sequence;
	}
	public void setSequence(BigDecimal sequence) {
		this.sequence = sequence;
	}
	
}
