package com.myproject.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loginerrorlog")
public class LoginErrorLogEntity {

	@Id
	private long logID;
    private LocalDateTime errorTimestamp;
	
    public long getLogID() {
		return logID;
	}
	public void setLogID(long logID) {
		this.logID = logID;
	}
	public LocalDateTime getErrorTimestamp() {
		return errorTimestamp;
	}
	public void setErrorTimestamp(LocalDateTime errorTimestamp) {
		this.errorTimestamp = errorTimestamp;
	}
}
