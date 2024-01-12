package com.example.demo.entity;




import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class EmployeeEntity {

  @Id
  @GeneratedValue
  private Long employeeId;
  
  //@Size(min=15, message="Name should have at least 15 characters")  
  private String firstName;
  
  public EmployeeEntity() {
	  super();
  }
  
 public EmployeeEntity(String firstName) {
	 super();
	 //this.employeeId = employeeId;
	 this.firstName = firstName;
 }
 
public Long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}
public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}
  
public String toString() {
	return firstName + "id:"+ employeeId;
}

}


