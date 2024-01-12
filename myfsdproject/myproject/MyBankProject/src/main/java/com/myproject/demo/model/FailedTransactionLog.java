package com.myproject.demo.model;
import java.time.LocalDateTime;

public class FailedTransactionLog {

	private long failedTransactionID;
	private LocalDateTime failedTransactionErrorTime;
	private FailedTransactionErrorType failedTransactionErrorType;
	
	public long getFailedTransactionID() {
		return failedTransactionID;
	}
	public void setFailedTransactionID(long failedTransactionID) {
		this.failedTransactionID = failedTransactionID;
	}
	public LocalDateTime getFailedTransactionErrorTime() {
		return failedTransactionErrorTime;
	}
	public void setFailedTransactionErrorTime(LocalDateTime failedTransactionErrorTime) {
		this.failedTransactionErrorTime = failedTransactionErrorTime;
	}
	public FailedTransactionErrorType getFailedTransactionErrorType() {
		return failedTransactionErrorType;
	}
	public void setFailedTransactionErrorType(FailedTransactionErrorType failedTransactionErrorType) {
		this.failedTransactionErrorType = failedTransactionErrorType;
	}
	
	
}
