package com.myproject.demo.model;
import java.time.LocalDateTime;

public class LoginErrorLog {

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
