package com.myproject.demo.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.UserLoginEntity;
import com.myproject.demo.repository.UserLoginRepository;
import com.myproject.demo.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public String loginUser(String username, String password) {
        List<UserLoginEntity> users = userLoginRepository.findAll();
        
        for (UserLoginEntity user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "Login successfully";
            }
        }
        
        return "Invalid username or password";
    }
}
