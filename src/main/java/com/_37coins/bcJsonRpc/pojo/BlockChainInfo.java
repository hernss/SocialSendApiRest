package com._37coins.bcJsonRpc.pojo;

public class BlockChainInfo {
	private String  chain;
	private long blocks;
	private long headers;
	private String  bestblockhash;
	private double difficulty;
	private double verificationprogress;
	private String  chainwork;
	
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
	public long getBlocks() {
		return blocks;
	}
	public void setBlocks(long blocks) {
		this.blocks = blocks;
	}
	public long getHeaders() {
		return headers;
	}
	public void setHeaders(long headers) {
		this.headers = headers;
	}
	public String getBestblockhash() {
		return bestblockhash;
	}
	public void setBestblockhash(String bestblockhash) {
		this.bestblockhash = bestblockhash;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	public double getVerificationprogress() {
		return verificationprogress;
	}
	public void setVerificationprogress(double verificationprogress) {
		this.verificationprogress = verificationprogress;
	}
	public String getChainwork() {
		return chainwork;
	}
	public void setChainwork(String chainwork) {
		this.chainwork = chainwork;
	}

}
