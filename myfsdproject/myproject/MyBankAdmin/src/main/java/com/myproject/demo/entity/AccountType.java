package com.myproject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adminaccounttype")
public class AccountType {
	
	@Id
	@Column(name = "accounttypeid")
	private int accountTypeId;
	
	@Column(name = "accounttypename")
	private String accountTypeName;

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	
	

	

}
