package com.example.demo.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.EmployeeBusiness;
import com.example.demo.entity.EmployeeEntity;

import com.example.demo.business.TravellerBusiness;
import com.example.demo.entity.TravellerEntity;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TravellerController {

	@Autowired
	private TravellerBusiness travBusiness;
	
	@RequestMapping("/saveTraveller")
	public String save() {
		String msg = travBusiness.save();
		return msg;
	}
	
	@RequestMapping("/savetrav/fname/{fname}")
	public String saveTrav(@PathVariable String fname) {
		String msg = travBusiness.save(fname);
		return msg;
	}
	
	
	@PostMapping(path = "/saveTravPost")
	public String saveTravPost(@Valid @RequestBody TravellerEntity travObj) {
		String msg = travBusiness.saveTraveller(travObj);
		return msg;
	}
	
	@RequestMapping("/findalltrav")
	public List saveFindAll() {
		return travBusiness.findAll();
		//return "Welcome from boot";
	}
	
	@DeleteMapping("/remove/travid/{travid}")
	public String removeTrav(@PathVariable Long travellerId) {
		String msg = travBusiness.remove(travellerId);
		return msg;
	}


	@RequestMapping("/saveflt/flightname/{flightname}")
	public String saveFlight(@PathVariable String flightname) {
		String msg = travBusiness.saveFlight(flightname);
		return msg;
	}
	
	@GetMapping("/transferFlight")
	ResponseEntity<String> transfer() {
	    //return new ResponseEntity<>("Transfer Completed", HttpStatus.OK);
		return new ResponseEntity<>("Transfer failed", HttpStatus.BAD_REQUEST);
	}
}
