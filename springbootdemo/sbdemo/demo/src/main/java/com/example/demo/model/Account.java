package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Account {
	
	private String outstandingBalance;

	public Account() {
		outstandingBalance = "4234.76";
		System.out.println("my balance" + getOutstandingBalance());
	}
	public String getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(String outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	
	

}