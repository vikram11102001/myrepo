package com.myproject.model;
import java.util.Date;

public class OverDraftLog {

	private Account account;
	private Date overDraftDate;
	private double overDraftAmount;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getOverDraftDate() {
		return overDraftDate;
	}
	public void setOverDraftDate(Date overDraftDate) {
		this.overDraftDate = overDraftDate;
	}
	public double getOverDraftAmount() {
		return overDraftAmount;
	}
	public void setOverDraftAmount(double overDraftAmount) {
		this.overDraftAmount = overDraftAmount;
	}
	
	
}
