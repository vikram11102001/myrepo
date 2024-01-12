package com.example.demo.entity;




import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class TravellerEntity {

  @Id
  @GeneratedValue
  private int travellerId;
  
  //@Size(min=15, message="Name should have at least 15 characters")  
  private String firstName;
  private String lastName;
  private String passWord;
  
  public TravellerEntity() {
	  super();
  }
  
 public TravellerEntity(String firstName) {
	 super();
	 //this.employeeId = employeeId;
	 this.firstName = firstName;
 }
 

  
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

public String toString() {
	return firstName + "id:"+ travellerId;
}

}


