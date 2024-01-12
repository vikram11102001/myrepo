package com.example.demo.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.data.DepartmentCrud;
import com.example.demo.data.EmployeeCrud;
import com.example.demo.entity.*;

@Service
public class EmployeeBusiness {
	
	@Autowired
	private EmployeeCrud empCrud;
	
	@Autowired
	private DepartmentCrud deptCrud;
	
	public String save() {
		EmployeeEntity emp = new EmployeeEntity("John");
		empCrud.save(emp);
		System.out.println("employee id is: " + emp.getEmployeeId());
		return "Saved the data" + emp.getEmployeeId() + "--" + emp.getFirstName();
	}
	
	public String save(String fname) {
		EmployeeEntity emp = new EmployeeEntity(fname);
		empCrud.save(emp);
		System.out.println("inside save fname method employee id is: " + emp.getEmployeeId());
		System.out.println("Find method " + empCrud.findById(1L));
		return "Saved the data" + emp.getEmployeeId() + "--" + emp.getFirstName();
	}
	
	public String saveEmployee(EmployeeEntity emp) {
		empCrud.save(emp);
		System.out.println("employee id is: " + emp.getEmployeeId());
		return "Saved the data" + emp.getEmployeeId() + "--" + emp.getFirstName();
	}
	
	public List findAll() {
		return empCrud.findAll();
	}
	
	public String remove(Long id) {
		empCrud.deleteById(id);
		return "Removed the data";
	}

	//lombok changes
	public String saveDept(String name) {
		Department dept = new Department(name);
		deptCrud.save(dept);
		System.out.println("inside saveDept method dept id is: " + dept.getId());
		//System.out.println("Find method " + deptCrud.findById(1L));
		return "Saved the data" + dept.getId() + "--" + dept.getName();
	}
	
}

