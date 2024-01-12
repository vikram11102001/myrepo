package com.myproject.demo.business;

import com.myproject.demo.model.Account;
import com.myproject.demo.model.Customer;

public interface DashboardBusiness {

	public Customer getCustomerById(String customerId);
	public Account getAccountByCustomerId(String customerId);
}
