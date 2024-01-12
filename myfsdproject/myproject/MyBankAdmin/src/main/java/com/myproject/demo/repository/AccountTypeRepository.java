package com.myproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.demo.entity.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>{

}
