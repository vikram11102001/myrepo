package com.myproject.demo.service;

import com.myproject.demo.model.Account;
import com.myproject.demo.model.Customer;

public interface DashboardService {

	public Customer getCustomerById(String customerId);
	public Account getAccountByCustomerId(String customerId);
}
