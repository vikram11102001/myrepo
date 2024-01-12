package com.myproject.demo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.business.DashboardBusiness;
import com.myproject.demo.model.Account;
import com.myproject.demo.model.Customer;
import com.myproject.demo.service.DashboardService;

@Service
public class DashboardBusinessImpl implements DashboardBusiness{
	
	@Autowired
	private DashboardService dashboardService;

	@Override
	public Customer getCustomerById(String customerId) {
		return dashboardService.getCustomerById(customerId);
	}
	
	@Override 
	public Account getAccountByCustomerId(String customerId) {
		return dashboardService.getAccountByCustomerId(customerId);
	}
}
