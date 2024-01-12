package com.myproject.entities;

import com.myproject.model.Account;
import com.myproject.model.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "customeraccount")
public class CustomerAccountEntity {
	
	@OneToOne
	@JoinColumn(name = "customerid", referencedColumnName = "customerid", table = "customer")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "accountid", referencedColumnName = "accountid", table = "account")
	private Account account;
	
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
