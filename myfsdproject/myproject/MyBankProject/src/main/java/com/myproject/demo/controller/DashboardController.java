package com.myproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myproject.demo.business.DashboardBusiness;
import com.myproject.demo.model.Account;
import com.myproject.demo.model.Customer;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardBusiness dashboardBusiness;
	
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable String customerId) {
		return dashboardBusiness.getCustomerById(customerId);
	}

	@GetMapping("/account/{customerId}")
	public Account getAccountByCustomerId(@PathVariable String customerId) {
		return dashboardBusiness.getAccountByCustomerId(customerId);
	}
}
