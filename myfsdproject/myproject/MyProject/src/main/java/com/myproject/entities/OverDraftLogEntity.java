package com.myproject.entities;

import jakarta.persistence.*;
import java.util.Date;
import com.myproject.model.Account;

@Entity
@Table(name = "overdraftlog")
public class OverDraftLogEntity {

	@ManyToOne
    @JoinColumn(name = "accountid", referencedColumnName = "accountid", table = "account")
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
