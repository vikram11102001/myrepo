package com.myproject.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.CustomerEntity;
import com.myproject.demo.entity.AccountEntity;
import com.myproject.demo.model.Account;
import com.myproject.demo.model.Customer;
import com.myproject.demo.repository.AccountRepository;
import com.myproject.demo.repository.CustomerRepository;

import com.myproject.demo.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Customer getCustomerById(String customerId) {
		CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        return mapCustomerEntityToModel(customerEntity);
	}
	
	public Account getAccountByCustomerId(String customerId) {
        AccountEntity accountEntity = accountRepository.findById(customerId);
        return mapCustomerEntityToModel(accountEntity);
    }
	public Customer mapCustomerEntityToModel(CustomerEntity customerEntity) {
		Customer customer = new Customer();
	    if (customerEntity != null) {
	    	customer.setCustomerID(customerEntity.getCustomerID());
	    	customer.setFirstName(customerEntity.getFirstName());
	    	customer.setLastName(customerEntity.getLastName());
	    	customer.setMobileNo(customerEntity.getMobileNo());
	    	customer.setAddress(customerEntity.getAddress());
	    	customer.setCityName(customerEntity.getCityName());
	    	customer.setStateName(customerEntity.getStateName());
	    	customer.setPinCode(customerEntity.getPinCode());
	    	customer.setEmailID(customerEntity.getEmailID());
	        
	    }
	    return customer;
	}

	
	
}
