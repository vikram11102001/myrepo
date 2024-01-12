package com.myproject.demo.model;

public class AccountType {

	private long accountTypeID;
    private String typeName;
    private String description;
	
    public long getAccountTypeID() {
		return accountTypeID;
	}
	public void setAccountTypeID(long accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
