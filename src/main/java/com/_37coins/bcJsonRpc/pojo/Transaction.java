package com._37coins.bcJsonRpc.pojo;


import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Transaction {
	/*
	 * {
    "hex" : "0100000001b450ecd444e0e776e4adbd4c88d245cde75aee51755903e5d63e23c0f2585275010000006b483045022100e35212c225f54a927359888964ac505022bd17038bfd4a79f335570aada95549022049da0d79c6dbe6396f87c302b38391cc88ff0620b08ad6a6eace6f65ff8e2eb8012102d29abd37b099eaeef5db8e7e980aad2242ffce391b3b00fa61e8f001bfb48d22ffffffff0200ca9a3b000000001976a914434eedde15fb628a918ebbade9941e09c66832c488ac092e8d7f080000001976a914352dc68dd30f60ecad610c1750f3cd2812e8209688ac00000000",
    "txid" : "9cf191f9e4cba0475ebb880ecaf8569b73dfd843481b66b8c8732519fbd85012",
    "version" : 1,
    "locktime" : 0,
    "vin" : [
        {
            "txid" : "755258f2c0233ed6e503597551ee5ae7cd45d2884cbdade476e7e044d4ec50b4",
            "vout" : 1,
            "scriptSig" : {
                "asm" : "3045022100e35212c225f54a927359888964ac505022bd17038bfd4a79f335570aada95549022049da0d79c6dbe6396f87c302b38391cc88ff0620b08ad6a6eace6f65ff8e2eb801 02d29abd37b099eaeef5db8e7e980aad2242ffce391b3b00fa61e8f001bfb48d22",
                "hex" : "483045022100e35212c225f54a927359888964ac505022bd17038bfd4a79f335570aada95549022049da0d79c6dbe6396f87c302b38391cc88ff0620b08ad6a6eace6f65ff8e2eb8012102d29abd37b099eaeef5db8e7e980aad2242ffce391b3b00fa61e8f001bfb48d22"
            },
            "sequence" : 4294967295
        }
    ],
    "vout" : [
        {
            "value" : 10.00000000,
            "n" : 0,
            "scriptPubKey" : {
                "asm" : "OP_DUP OP_HASH160 434eedde15fb628a918ebbade9941e09c66832c4 OP_EQUALVERIFY OP_CHECKSIG",
                "hex" : "76a914434eedde15fb628a918ebbade9941e09c66832c488ac",
                "reqSigs" : 1,
                "type" : "pubkeyhash",
                "addresses" : [
                    "STRtrnjav8MGfTrkUn1BgMwdCU9mwYCQff"
                ]
            }
        },
        {
            "value" : 364.99697161,
            "n" : 1,
            "scriptPubKey" : {
                "asm" : "OP_DUP OP_HASH160 352dc68dd30f60ecad610c1750f3cd2812e82096 OP_EQUALVERIFY OP_CHECKSIG",
                "hex" : "76a914352dc68dd30f60ecad610c1750f3cd2812e8209688ac",
                "reqSigs" : 1,
                "type" : "pubkeyhash",
                "addresses" : [
                    "SS9BgZ3sBWnmQvkq1ic4pFCCJ3tkrRKmS5"
                ]
            }
        }
    ],
    "blockhash" : "d0f1458c2b8c0cd8d9f199d95a16905ac8dc797f85a36bd9e7f7603e10a59259",
    "confirmations" : 123133,
    "time" : 1515343249,
    "blocktime" : 1515343249
}


	 */
	private String hex;
	private String txid;
	private long version;
	private long locktime;
	private List<Vin> vin;
	private List<Vout> vout;
	private String blockhash;
	private BigDecimal confirmations;
	private long time;
	private long blocktime;
	
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
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
	public String getBlockhash() {
		return blockhash;
	}
	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}
	public BigDecimal getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(BigDecimal confirmations) {
		this.confirmations = confirmations;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getBlocktime() {
		return blocktime;
	}
	public void setBlocktime(long blocktime) {
		this.blocktime = blocktime;
	}
   
    
    
}
