package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.google.gson.Gson;

@RestController
@RequestMapping("hello")
public class HelloController {

	@Value("${dbservername}")
	private String dbservername;
	
	@Value("${dbserveruserid}")
	private String dbserveruserid;
	
	@GetMapping("/abc/{name}")
	
	 public @ResponseBody String helloUser(@PathVariable String name) {
		System.out.println(dbservername);
		System.out.println(dbserveruserid);
        return "Hello, welcome adasda" + name;
    }

	@GetMapping("/helloworld")
	
	 public @ResponseBody String helloWorld() {
       return "Hello java fsd";
   }
	
	//return the response as JSON string
	//'{"name":"John", "studentId":"123", "departmentName":"ECE"}'
	/*

			{
			  "name": "John",
			  "studentId": "123",
			  "departmentName": "ECE"
			}


	 */
	@GetMapping("/getStudents")
	public @ResponseBody String studentList() {
		
			//Invoke business class methods here.
			//Get the data.
		//Below is the mock data.
		
			Student s1 = new Student();
			s1.setStudentId(123);
			s1.setDepartmentName("ECE");
			s1.setName("John");
			
			Student s2 = new Student();
			s2.setStudentId(124);
			s2.setDepartmentName("ECE");
			s2.setName("Lisa");

			ArrayList list = new ArrayList();
			list.add(s1);
			list.add(s2);
			
			   Gson gson = new Gson();
		    String jsonArray = gson.toJson(list);
			return jsonArray;
	   }
}
