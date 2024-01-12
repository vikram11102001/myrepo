package com.myproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "transactiontype")
public class TransactionTypeEntity {
	
	@Id
	private long transactionTypeID;
    private String typeName;
    private String description;
    private double transactionFeeAmount;
	
    public long getTransactionTypeID() {
		return transactionTypeID;
	}
	public void setTransactionTypeID(long transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
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
	public double getTransactionFeeAmount() {
		return transactionFeeAmount;
	}
	public void setTransactionFeeAmount(double transactionFeeAmount) {
		this.transactionFeeAmount = transactionFeeAmount;
	}
}
