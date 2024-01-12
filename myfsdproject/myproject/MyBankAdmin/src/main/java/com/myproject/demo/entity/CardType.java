package com.myproject.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "admincardtype")
public class CardType {
	
	@Id
	@Column(name = "cardtypeid")
	private int cardTypeId;
	
	@Column(name = "cardtypename")
	private String cardTypeName;

	public int getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	
	

}
