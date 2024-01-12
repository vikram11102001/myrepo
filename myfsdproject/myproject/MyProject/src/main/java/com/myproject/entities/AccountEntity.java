package com.myproject.entities;

import jakarta.persistence.*;


import com.myproject.model.AccountStatusType;
import com.myproject.model.AccountType;
import com.myproject.model.SavingInterestRate;

@Entity
@Table(name = "account")
public class AccountEntity {
	
	@Id
	private long accountID;
    private double balance;
    
    @OneToOne
    @JoinColumn(name = "accounttypeid", referencedColumnName = "accounttypeid", table = "accounttype")
	private AccountType accountType;
    
    @OneToOne
    @JoinColumn(name = "accountstatustypeid", referencedColumnName = "accountstatustypeid", table = "accountstatustype")
	private AccountStatusType accountStatusType;
    
    @OneToOne
    @JoinColumn(name = "interestsavingrateid", referencedColumnName = "interestsavingrateid", table = "savinginterestrate")
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
