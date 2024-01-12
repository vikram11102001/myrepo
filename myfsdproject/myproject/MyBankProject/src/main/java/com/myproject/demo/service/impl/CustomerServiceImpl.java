package com.myproject.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.CustomerEntity;
import com.myproject.demo.repository.CustomerRepository;
import com.myproject.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(CustomerEntity customer) {
        // Additional validation or data processing can be done here
    	customerRepository.save(customer);
        return "customer created successfully";
    }
}