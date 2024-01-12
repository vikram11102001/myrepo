package com.myproject.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.CardType;
import com.myproject.demo.repository.CardTypeRepository;
import com.myproject.demo.service.CardTypeService;

@Service
public class CardTypeServiceImpl implements CardTypeService{

	@Autowired
    private CardTypeRepository cardTypeRepository;

    @Override
    public String createCardType(CardType cardType) {
        // Additional validation or data processing can be done here
    	cardTypeRepository.save(cardType);
        return "customer created successfully";
    }
}
