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
	
	/*
	 * {
            "txid" : "755258f2c0233ed6e503597551ee5ae7cd45d2884cbdade476e7e044d4ec50b4",
            "vout" : 1,
            "scriptSig" : {
                "asm" : "3045022100e35212c225f54a927359888964ac505022bd17038bfd4a79f335570aada95549022049da0d79c6dbe6396f87c302b38391cc88ff0620b08ad6a6eace6f65ff8e2eb801 02d29abd37b099eaeef5db8e7e980aad2242ffce391b3b00fa61e8f001bfb48d22",
                "hex" : "483045022100e35212c225f54a927359888964ac505022bd17038bfd4a79f335570aada95549022049da0d79c6dbe6396f87c302b38391cc88ff0620b08ad6a6eace6f65ff8e2eb8012102d29abd37b099eaeef5db8e7e980aad2242ffce391b3b00fa61e8f001bfb48d22"
            },
            "sequence" : 4294967295
        }
	 */
	
	private String coinbase;
	private BigDecimal sequence;
	private long vout;
	private String txid;
	private ScriptPubKey scriptSig;
	
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
	public long getVout() {
		return vout;
	}
	public void setVout(long vout) {
		this.vout = vout;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public ScriptPubKey getScriptSig() {
		return scriptSig;
	}
	public void setScriptSig(ScriptPubKey scriptSig) {
		this.scriptSig = scriptSig;
	}
	
}
