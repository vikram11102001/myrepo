package com.myproject.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userlogin")
public class UserLoginEntity {

	@Id
	@Column(name = "userloginid")
	private long loginID;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "custid")
	private String custId;
	
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
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
}
