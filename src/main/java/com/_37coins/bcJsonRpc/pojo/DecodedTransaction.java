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
	
	/*
	 * {
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
    ]
}

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

