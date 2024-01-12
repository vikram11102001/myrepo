package com.myproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.demo.entity.UserLoginEntity;

public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long>{
	
	
}
