package com.example.demo.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.data.FlightCrud;
import com.example.demo.data.TravellerCrud;
import com.example.demo.entity.*;

@Service
public class TravellerBusiness {
	
	@Autowired
	private TravellerCrud travCrud;
	
	@Autowired
	private FlightCrud fltCrud;
	
	public String save() {
		TravellerEntity trav = new TravellerEntity("John");
		travCrud.save(trav);
		System.out.println("traveller id is: " + trav.getTravellerId());
		return "Saved the data" + trav.getTravellerId() + "--" + trav.getFirstName();
	}
	
	public String save(String fname) {
		TravellerEntity trav = new TravellerEntity(fname);
		travCrud.save(trav);
		System.out.println("inside save fname method employee id is: " + trav.getTravellerId());
		System.out.println("Find method " + travCrud.findById(1L));
		return "Saved the data" + trav.getTravellerId() + "--" + trav.getFirstName();
	}
	
	public String saveTraveller(TravellerEntity trav) {
		travCrud.save(trav);
		System.out.println("Traveller id is: " + trav.getTravellerId());
		return "Saved the data" + trav.getTravellerId() + "--" + trav.getFirstName();
	}
	
	public List findAll() {
		return travCrud.findAll();
	}
	
	public String remove(Long id) {
		travCrud.deleteById(id);
		return "Removed the data";
	}

	//lombok changes
	public String saveFlight(String flightname) {
		FlightEntity flight = new FlightEntity(flightname);
		fltCrud.save(flight);
		System.out.println("inside saveDept method dept id is: " + flight.getFlightId());
		//System.out.println("Find method " + deptCrud.findById(1L));
		return "Saved the data" + flight.getFlightId() + "--" + flight.getFlightName();
	}
	
}

