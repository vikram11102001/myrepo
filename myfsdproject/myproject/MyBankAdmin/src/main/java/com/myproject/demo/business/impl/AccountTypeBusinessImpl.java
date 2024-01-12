package com.myproject.demo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.business.AccountTypeBusiness;
import com.myproject.demo.service.AccountTypeService;
import com.myproject.demo.entity.AccountType;

@Service
public class AccountTypeBusinessImpl implements AccountTypeBusiness{
	@Autowired
	private AccountTypeService accountTypeService;

	public String  createAccountType(AccountType accountType) {
		// Add any additional business logic here if needed
		String msg = accountTypeService.createAccountType(accountType);
		return msg;
	}

	
}
