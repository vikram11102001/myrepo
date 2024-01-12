package com.myproject.demo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myproject.demo.business.CustomerBusiness;
import com.myproject.demo.entity.CustomerEntity;
import com.myproject.demo.service.CustomerService;

@Service
public class CustomerBusinessImpl implements CustomerBusiness {

    @Autowired
    private CustomerService customerService;

    public String  createCustomer(CustomerEntity customer) {
        // Add any additional business logic here if needed
    	String msg = customerService.createCustomer(customer);
        return msg;
    }
}

