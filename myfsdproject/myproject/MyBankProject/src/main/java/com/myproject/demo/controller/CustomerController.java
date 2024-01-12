package com.myproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myproject.demo.business.CustomerBusiness;
import com.myproject.demo.entity.CustomerEntity;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    private CustomerBusiness customerBusiness;

    @PostMapping("/customers")
    public String createClient(@RequestBody CustomerEntity customer) {
        String msg = customerBusiness.createCustomer(customer);
        return msg;
    }
}
