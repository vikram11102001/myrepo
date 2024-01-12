package com.myproject.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.AccountType;
import com.myproject.demo.repository.AccountTypeRepository;
import com.myproject.demo.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
	
	@Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public String createAccountType(AccountType accountType) {
        // Additional validation or data processing can be done here
    	accountTypeRepository.save(accountType);
        return "customer created successfully";
    }
}
