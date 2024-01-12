package com.myproject.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.myproject.model.FailedTransactionErrorType;

@Entity
@Table(name = "failedtransaction")
public class FailedTransactionLogEntity {

	@Id
	private long failedTransactionID;
	private LocalDateTime failedTransactionErrorTime;
	
	@ManyToOne
	@JoinColumn(name = "failedtransactionerrortypeid", referencedColumnName = "failedtransactionerrortypeid", table = "failedtransactionerrortype")
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
