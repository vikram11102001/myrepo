package com.myproject.demo.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.business.UserLoginBusiness;
import com.myproject.demo.entity.UserLoginEntity;
import com.myproject.demo.service.UserLoginService;

@Service
public class UserLoginBusinessImpl implements UserLoginBusiness{

	@Autowired
    private UserLoginService userLoginService;

	public String loginUser(String username, String password) {
		  String msg = userLoginService.loginUser(username, password);
		  return msg;
	}
    
}
