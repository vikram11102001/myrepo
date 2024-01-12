package com.myproject.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	
	@Id
	@Column(name = "customerid")
	private String customerID;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "mobileno")
	private long mobileNo;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String cityName;
	
	@Column(name = "state")
	private String stateName;
	
	@Column(name = "pincode")
	private String pinCode;
	
	@Column(name = "emailid")
	private String emailID;
	
	
	

	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String cutomerID) {
		this.customerID = cutomerID;
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
