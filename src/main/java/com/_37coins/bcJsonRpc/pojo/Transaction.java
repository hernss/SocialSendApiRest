package com._37coins.bcJsonRpc.pojo;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Transaction {
	/*
	 * {
    "amount" : -3.00000000,
    "fee" : 11.99998519,
    "confirmations" : 147198,
    "bcconfirmations" : 147198,
    "generated" : true,
    "blockhash" : "e08deb105e9d2da7d68cc2af1f4e62c821221c67b3000930ae1f32f06faa1244",
    "blockindex" : 1,
    "blocktime" : 1513633485,
    "txid" : "68ad2f356fbe92b2513ce0f483a056100cb9c999aab0e6d8e0e0fda255769506",
    "walletconflicts" : [
    ],
    "time" : 1513633456,
    "timereceived" : 1513633456,
    "details" : [
        {
            "account" : "",
            "category" : "send",
            "amount" : 0.00000000,
            "vout" : 0,
            "fee" : 11.99998519
        },
        {
            "account" : "",
            "address" : "ST7brMpLSMGhfW5viES8oXzZKnHdKLM3tA",
            "category" : "send",
            "amount" : -3134.75000000,
            "vout" : 1,
            "fee" : 11.99998519
        },
        {
            "account" : "",
            "address" : "ST7brMpLSMGhfW5viES8oXzZKnHdKLM3tA",
            "category" : "send",
            "amount" : -3131.75989943,
            "vout" : 2,
            "fee" : 11.99998519
        },
        {
            "account" : "",
            "address" : "STNR6JMnMyeCjFHcj2NcnyBczX9uS5jPrs",
            "category" : "send",
            "amount" : -3.00000000,
            "vout" : 3,
            "fee" : 11.99998519
        },
        {
            "account" : "",
            "address" : "ST7brMpLSMGhfW5viES8oXzZKnHdKLM3tA",
            "category" : "receive",
            "amount" : 3134.75000000,
            "vout" : 1
        },
        {
            "account" : "",
            "address" : "ST7brMpLSMGhfW5viES8oXzZKnHdKLM3tA",
            "category" : "receive",
            "amount" : 3131.75989943,
            "vout" : 2
        }
    ],
    "hex" : "01000000019d62285692b2cc5d8e5baec138e3fdc5bf96e8aff5e1d029c929c5611f4ec412020000004847304402201eaa5498cb864ef06c2574df47861da659a9e55c06c0f89ee4470fecf675999702204a826ea0a76915f0f15f8fde109145ec937963d5ff736d7b825c7995c37d90de01ffffffff04000000000000000000c0e690fc48000000232103bb7f241d25be06263dbe4588d2d0059d25511c4fa543f69b04294f3e87136ee6acb75ebeea48000000232103bb7f241d25be06263dbe4588d2d0059d25511c4fa543f69b04294f3e87136ee6ac00a3e111000000001976a91442a680a4bcae3ad7d995499032061a233bf3e79988ac00000000"
}

	 */
	

	
	private double amount;
	private double fee;
	private long confirmations;
	private long bcconfirmations;
	private boolean generated;
	private String blockhash;
	private long blockindex;
	private long blocktime;
	private String txid;
	private List<String> walletconflicts;
	private long time;
	private long timereceived;
	private List<TransactionDetail> details;
    private String hex;
    
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public long getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}
	public long getBcconfirmations() {
		return bcconfirmations;
	}
	public void setBcconfirmations(long bcconfirmations) {
		this.bcconfirmations = bcconfirmations;
	}
	public boolean isGenerated() {
		return generated;
	}
	public void setGenerated(boolean generated) {
		this.generated = generated;
	}
	public String getBlockhash() {
		return blockhash;
	}
	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}
	public long getBlockindex() {
		return blockindex;
	}
	public void setBlockindex(long blockindex) {
		this.blockindex = blockindex;
	}
	public long getBlocktime() {
		return blocktime;
	}
	public void setBlocktime(long blocktime) {
		this.blocktime = blocktime;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public List<String> getWalletconflicts() {
		return walletconflicts;
	}
	public void setWalletconflicts(List<String> walletconflicts) {
		this.walletconflicts = walletconflicts;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getTimereceived() {
		return timereceived;
	}
	public void setTimereceived(long timereceived) {
		this.timereceived = timereceived;
	}
	public List<TransactionDetail> getDetails() {
		return details;
	}
	public void setDetails(List<TransactionDetail> details) {
		this.details = details;
	}
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
    

   
    
    
}
