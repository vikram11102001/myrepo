package com.demo.onetomany.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "ForeignKeyAssoFlightEntity")
@Table(name = "FLIGHT_1_M", uniqueConstraints = @UniqueConstraint(columnNames = "flightid"))

public class FlightEntityOneToMany implements Serializable{
	
	  @Serial
	  private static final long serialVersionUID = -6790693372846798580L;

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "flightid")
	  private int flightId;

	  @Column(name = "flightname")
	  private String flightName;
	  
	  @Column(name = "source")
	  private String sourceName;
	  
	  @Column(name = "destination")
	  private String destinationName;
	  
	  @Column(name = "dateandtime", nullable = false)
	  private String dateandTime;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDateandTime() {
		return dateandTime;
	}

	public void setDateandTime(String dateandTime) {
		this.dateandTime = dateandTime;
	}
	  
	  

}
