package com.myproject.demo.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.business.CardTypeBusiness;
import com.myproject.demo.entity.CardType;
import com.myproject.demo.service.CardTypeService;

@Service

public class CardTypeBusinessImpl implements CardTypeBusiness {

	@Autowired
	private CardTypeService cardTypeService;

	public String  createCardType(CardType cardType) {
		// Add any additional business logic here if needed
		String msg = cardTypeService.createCardType(cardType);
		return msg;
	}
}
