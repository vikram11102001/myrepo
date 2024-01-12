package com.example.demo.entity;


import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@Getter @Setter @NoArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Department() {
		
	}

	public Department(String name) {
		 super();
		 //this.employeeId = employeeId;
		 this.name = name;
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

