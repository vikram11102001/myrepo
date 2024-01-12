package com.myproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "accountstatustype")
public class AccountStatusTypeEntity {

	@Id
	private long statusID;
    private String statusName;
    private String description;
	
    public long getStatusID() {
		return statusID;
	}
	public void setStatusID(long statusID) {
		this.statusID = statusID;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
