package com.demo.onetoone.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
@Builder
@Entity(name = "ForeignKeyAssEmployeeEntity")
@Table(name = "Employee_1_1", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID"),
    @UniqueConstraint(columnNames = "EMAIL")})
public class EmployeeEntity implements Serializable {

  private static final long serialVersionUID = -1798070786993154676L;

  public EmployeeEntity() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  private Integer employeeId;

  @Column(name = "EMAIL", unique = false, nullable = false, length = 100)
  private String email;

  @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
  private String firstName;

  @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
  private String lastName;

  @OneToOne
  @JoinColumn(name = "ACCOUNT_ID")
  @OrderBy("firstName ASC, email DESC")
  private AccountEntity account;

public Integer getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(Integer employeeId) {
	this.employeeId = employeeId;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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

public AccountEntity getAccount() {
	return account;
}

public void setAccount(AccountEntity account) {
	this.account = account;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
  
  
}
