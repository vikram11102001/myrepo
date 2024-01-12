package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	private String userName;
	
	//private Account account = new Account();
	@Autowired
	private Account account;

	public String getUserName() {
		return userName;
	}
	
	//@NotNull(message = "Name may not be null")
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//@Bean
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
