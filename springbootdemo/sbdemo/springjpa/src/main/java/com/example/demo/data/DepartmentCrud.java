package com.example.demo.data;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.EmployeeEntity;

@Repository
public interface DepartmentCrud extends JpaRepository<Department, Long>{

}
