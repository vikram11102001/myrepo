package com.myproject.demo.controller;

import com.myproject.demo.entity.AccountType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demo.business.AccountTypeBusiness;



@RestController
@RequestMapping
public class AccountTypeController {
	@Autowired
    private AccountTypeBusiness accountTypeBusiness;

    @PostMapping("/customers")
    public String createAccountType(@RequestBody AccountType accountType) {
        String msg = accountTypeBusiness.createAccountType(accountType);
        return msg;
    }
}
