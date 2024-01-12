package com.myproject.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	
	
	private String cutomerID;
	private String firstName;
	private String lastName;
	private long mobileNo;
	private String address;
	private String cityName;
	private String stateName;
	private String pinCode;
	private String emailID;
	
	@Id
	public String getCutomerID() {
		return cutomerID;
	}
	public void setCutomerID(String cutomerID) {
		this.cutomerID = cutomerID;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}	
}
