package com._37coins.bcJsonRpc.pojo;

public class BotResponse {
	/*
	 *	priceBTC
	 *	priceUSD 
	 * 	Buy Volume
	 * 	Sell volume
	 * 	MasternodeCounts
	 * 	Masternode Value
	 * 	CoinsLocked (%)
	 * 	Daily Income 
	 *  ROI
	 *  
	 */
	private double priceBTC;
	private double priceUSD;
	private double buyVolume;
	private double sellVolume;
	private long masternodesCount;
	private double masternodeValue;
	private double coinsLocked;
	private double coinsLockedPor;
	private double dailyIncome;
	private double ROI;
	
	public double getPriceBTC() {
		return priceBTC;
	}
	public void setPriceBTC(double priceBTC) {
		this.priceBTC = priceBTC;
	}
	public double getPriceUSD() {
		return priceUSD;
	}
	public void setPriceUSD(double priceUSD) {
		this.priceUSD = priceUSD;
	}
	public double getBuyVolume() {
		return buyVolume;
	}
	public void setBuyVolume(double buyVolume) {
		this.buyVolume = buyVolume;
	}
	public double getSellVolume() {
		return sellVolume;
	}
	public void setSellVolume(double sellVolume) {
		this.sellVolume = sellVolume;
	}
	public long getMasternodesCount() {
		return masternodesCount;
	}
	public void setMasternodesCount(long masternodesCount) {
		this.masternodesCount = masternodesCount;
	}
	public double getMasternodeValue() {
		return masternodeValue;
	}
	public void setMasternodeValue(double masternodeValue) {
		this.masternodeValue = masternodeValue;
	}
	public double getCoinsLocked() {
		return coinsLocked;
	}
	public void setCoinsLocked(double coinsLocked) {
		this.coinsLocked = coinsLocked;
	}
	public double getCoinsLockedPor() {
		return coinsLockedPor;
	}
	public void setCoinsLockedPor(double coinsLockedPor) {
		this.coinsLockedPor = coinsLockedPor;
	}
	public double getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	public double getROI() {
		return ROI;
	}
	public void setROI(double rOI) {
		ROI = rOI;
	}
	
	
}
