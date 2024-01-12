package com.example.demo.entity;




import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
public class FlightEntity {

  @Id
  @GeneratedValue
  private int flightId;
  
  //@Size(min=15, message="Name should have at least 15 characters")  
  private String flightName;
  private String sourceName;
  private String destinationName;
  private String dateandTime;
  
  public FlightEntity() {
	  super();
  }
  
 public FlightEntity(String flightName) {
	 super();
	 //this.employeeId = employeeId;
	 this.flightName = flightName;
 }

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



