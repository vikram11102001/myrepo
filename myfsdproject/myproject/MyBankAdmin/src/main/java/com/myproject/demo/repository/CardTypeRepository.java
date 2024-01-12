package com.myproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.demo.entity.CardType;

public interface CardTypeRepository extends JpaRepository<CardType, Integer>{

}
