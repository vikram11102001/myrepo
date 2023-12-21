package com.demo.onetomany.dto;

import java.io.Serializable;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity(name = "ForeignKeyAssoTravellerEntity")
@Table(name = "TRAVELLER_1_M", uniqueConstraints = @UniqueConstraint(columnNames = "travellerid"))
public class TravellerEntityOneToMany implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "travellerid", unique = true, nullable = false)
	private int travellerId;

	@Column(name = "firstname", unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(name = "lastname", unique = false, nullable = false, length = 100)
	private String lastName;

	@Column(name = "password", unique = false, nullable = false, length = 100)
	private String passWord;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="travellerid")
	private Set<FlightEntityOneToMany> flights;

	public int getTravellerId() {
		return travellerId;
	}

	public void setTravellerId(int travellerId) {
		this.travellerId = travellerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Set<FlightEntityOneToMany> getFlights() {
		return flights;
	}

	public void setFlights(Set<FlightEntityOneToMany> flights) {
		this.flights = flights;
	}
	
	

}
