package com.myproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demo.business.CardTypeBusiness;
import com.myproject.demo.entity.CardType;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CardTypeController {

	@Autowired
    private CardTypeBusiness cardTypeBusiness;

    @PostMapping("/customers")
    public String createCardType(@RequestBody CardType cardType) {
        String msg = cardTypeBusiness.createCardType(cardType);
        return msg;
    }
}
