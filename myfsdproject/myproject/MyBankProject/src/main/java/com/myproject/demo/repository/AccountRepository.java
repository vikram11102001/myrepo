package com.myproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.demo.entity.AccountEntity;
import com.myproject.demo.entity.CustomerEntity;


@Repository
public interface AccountRepository extends JpaRepository<CustomerEntity, String> {
    
}
