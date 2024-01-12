package com.myproject.demo.model;

public class SavingInterestRate {

	private long rateID;
    private double interestRate;
    private String interestRateDesc;
	
    public long getRateID() {
		return rateID;
	}
	public void setRateID(long rateID) {
		this.rateID = rateID;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String getInterestRateDesc() {
		return interestRateDesc;
	}
	public void setInterestRateDesc(String interestRateDesc) {
		this.interestRateDesc = interestRateDesc;
	}
    
    
}
