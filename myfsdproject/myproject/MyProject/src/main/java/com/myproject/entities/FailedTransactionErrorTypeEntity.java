package com.myproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "failedtransactionerrortype")
public class FailedTransactionErrorTypeEntity {

	@Id
	private long failedTransactionErrorTypeID;
	private String failedTransactionDesc;
	
	public long getFailedTransactionErrorTypeID() {
		return failedTransactionErrorTypeID;
	}
	public void setFailedTransactionErrorTypeID(long failedTransactionErrorTypeID) {
		this.failedTransactionErrorTypeID = failedTransactionErrorTypeID;
	}
	public String getFailedTransactionDesc() {
		return failedTransactionDesc;
	}
	public void setFailedTransactionDesc(String failedTransactionDesc) {
		this.failedTransactionDesc = failedTransactionDesc;
	}
}
