package com.myproject.demo.model;

public class Account {

	private long accountID;
    private double balance;
	private AccountType accountType;
	private AccountStatusType accountStatusType;
	private SavingInterestRate savingInterestRate;
	
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public AccountStatusType getAccountStatusType() {
		return accountStatusType;
	}
	public void setAccountStatusType(AccountStatusType accountStatusType) {
		this.accountStatusType = accountStatusType;
	}
	public SavingInterestRate getSavingInterestRate() {
		return savingInterestRate;
	}
	public void setSavingInterestRate(SavingInterestRate savingInterestRate) {
		this.savingInterestRate = savingInterestRate;
	}
	
	
}
