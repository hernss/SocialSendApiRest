package com._37coins.bcJsonRpc.pojo;

import java.math.BigDecimal;
import java.util.List;

public class PeerInfo {
/*
  {
        "id" : 16,
        "addr" : "18.217.145.165:50050",
        "addrlocal" : "190.179.150.175:46652",
        "services" : "0000000000000005",
        "lastsend" : 1522537388,
        "lastrecv" : 1522537388,
        "bytessent" : 6539057,
        "bytesrecv" : 9327892,
        "conntime" : 1522503890,
        "pingtime" : 0.48556500,
        "version" : 70810,
        "subver" : "/SEND Core:1.0.0.7/",
        "inbound" : false,
        "startingheight" : 186490,
        "banscore" : 0,
        "synced_headers" : 187044,
        "synced_blocks" : 187044,
        "inflight" : [
        ],
        "whitelisted" : false
    }
 */
	private int id;
	private String addr;
	private String addrlocal;
	private String services;
	private BigDecimal lastsend;
	private BigDecimal lastrecv;
	private BigDecimal bytessent;
	private BigDecimal bytesrecv;
	private long conntime;
	private double pingtime;
	private long version;
	private String subver;
    private boolean inbound;
    private BigDecimal startingheight;
    private long banscore;
    private BigDecimal synced_headers;
    private BigDecimal synced_blocks;
    private List<BigDecimal> inflight;
    private boolean whitelisted;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrlocal() {
		return addrlocal;
	}
	public void setAddrlocal(String addrlocal) {
		this.addrlocal = addrlocal;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public BigDecimal getLastsend() {
		return lastsend;
	}
	public void setLastsend(BigDecimal lastsend) {
		this.lastsend = lastsend;
	}
	public BigDecimal getLastrecv() {
		return lastrecv;
	}
	public void setLastrecv(BigDecimal lastrecv) {
		this.lastrecv = lastrecv;
	}
	public BigDecimal getBytessent() {
		return bytessent;
	}
	public void setBytessent(BigDecimal bytessent) {
		this.bytessent = bytessent;
	}
	public BigDecimal getBytesrecv() {
		return bytesrecv;
	}
	public void setBytesrecv(BigDecimal bytesrecv) {
		this.bytesrecv = bytesrecv;
	}
	public long getConntime() {
		return conntime;
	}
	public void setConntime(long conntime) {
		this.conntime = conntime;
	}
	public double getPingtime() {
		return pingtime;
	}
	public void setPingtime(double pingtime) {
		this.pingtime = pingtime;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getSubver() {
		return subver;
	}
	public void setSubver(String subver) {
		this.subver = subver;
	}
	public boolean isInbound() {
		return inbound;
	}
	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}
	public BigDecimal getStartingheight() {
		return startingheight;
	}
	public void setStartingheight(BigDecimal startingheight) {
		this.startingheight = startingheight;
	}
	public long getBanscore() {
		return banscore;
	}
	public void setBanscore(long banscore) {
		this.banscore = banscore;
	}
	public BigDecimal getSynced_headers() {
		return synced_headers;
	}
	public void setSynced_headers(BigDecimal synced_headers) {
		this.synced_headers = synced_headers;
	}
	public BigDecimal getSynced_blocks() {
		return synced_blocks;
	}
	public void setSynced_blocks(BigDecimal synced_blocks) {
		this.synced_blocks = synced_blocks;
	}
	public List<BigDecimal> getInflight() {
		return inflight;
	}
	public void setInflight(List<BigDecimal> inflight) {
		this.inflight = inflight;
	}
	public boolean isWhitelisted() {
		return whitelisted;
	}
	public void setWhitelisted(boolean whitelisted) {
		this.whitelisted = whitelisted;
	}
	
	
}
