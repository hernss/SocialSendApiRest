package com._37coins.bcJsonRpc.pojo;

import java.math.BigDecimal;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown=true)

public class MasternodeCount {

	private BigDecimal total;
	private BigDecimal stable;
	private BigDecimal obfcompat;
	private BigDecimal enabled;
	private BigDecimal inqueue;
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getStable() {
		return stable;
	}
	public void setStable(BigDecimal stable) {
		this.stable = stable;
	}
	public BigDecimal getObfcompat() {
		return obfcompat;
	}
	public void setObfcompat(BigDecimal obfcompat) {
		this.obfcompat = obfcompat;
	}
	public BigDecimal getEnabled() {
		return enabled;
	}
	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}
	public BigDecimal getInqueue() {
		return inqueue;
	}
	public void setInqueue(BigDecimal inqueue) {
		this.inqueue = inqueue;
	}
	

}
