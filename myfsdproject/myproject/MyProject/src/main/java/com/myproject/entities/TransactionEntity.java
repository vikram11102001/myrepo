package com.myproject.entities;

import jakarta.persistence.*;
import java.util.Date;

import com.myproject.model.Account;
import com.myproject.model.Customer;
import com.myproject.model.TransactionType;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	private long transactionID;
	
	@ManyToOne
	@JoinColumn(name = "transactiontypeid", referencedColumnName = "transactiontypeid", table = "transactiontype")
	private TransactionType transactionType;
	
	private double amount;
    private Date transactionDate;
    private String description;
    
    @ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "customerid", table = "customer")
	private Customer customer;
    
    @ManyToOne
	@JoinColumn(name = "accountid", referencedColumnName = "accountid", table = "account")
	private Account account;
	
	public long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
