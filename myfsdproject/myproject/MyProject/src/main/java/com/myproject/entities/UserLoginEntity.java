package com.myproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "userlogin")
public class UserLoginEntity {

	@Id
	private long loginID;
    private String username;
    private String password;
	
    public long getLoginID() {
		return loginID;
	}
	public void setLoginID(long loginID) {
		this.loginID = loginID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
