package com.myproject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demo.business.UserLoginBusiness;
import com.myproject.demo.entity.UserLoginEntity;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")

public class UserLoginController {

    @Autowired
    private UserLoginBusiness userLoginBusiness;

    @GetMapping("/getusers")
    public String loginUser(String username, String password) {
        String msg = userLoginBusiness.loginUser(username, password);
        return msg;
    }
}
