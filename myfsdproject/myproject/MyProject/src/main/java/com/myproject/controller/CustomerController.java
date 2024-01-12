package com.myproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myproject.business.CustomerBusiness;
import com.myproject.entities.CustomerEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hello")
public class CustomerController {
	
	@Autowired
	private CustomerBusiness custBusiness;
	
	@PostMapping("/insertsamplecustomer")
	public String insertcustomer(@Valid @RequestBody CustomerEntity customerEnt){
		String msg = custBusiness.saveCust(customerEnt);
		return msg;
	}
	
	

}
