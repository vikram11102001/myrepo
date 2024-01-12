package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.demo.model.Flights;
import com.example.demo.model.Student;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.example.demo.model.FlightEntity;

@RestController
@RequestMapping("/hello")
public class HelloController {

    

    // ... Other GET mappings ...

    @GetMapping("/getFlights/{flightid}")
    public @ResponseBody String flightList(@PathVariable String flightid) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");

            // Create a SQL query with a parameterized statement
            String QUERY = "SELECT * FROM flights WHERE flightid = ?";

            // Create a PreparedStatement and set the parameter
            PreparedStatement preparedStatement = con.prepareStatement(QUERY);
            preparedStatement.setString(1, flightid);

            // Execute the query using the PreparedStatement
            ResultSet rs = preparedStatement.executeQuery();

            // Create a list to store flight objects
            ArrayList<Flights> flightList = new ArrayList<>();

            // Iterate through the result set and create flight objects
            while (rs.next()) {
                String flightId = rs.getString("flightid");
                String flightName = rs.getString("flightname");
                String sourcePlace = rs.getString("source");
                String destinationPlace = rs.getString("destination");
                String dateAndTime = rs.getString("dateandtime");

                Flights flightobj = new Flights();
                flightobj.setFlightid(flightId);
                flightobj.setFlightname(flightName);
                flightobj.setSource(sourcePlace);
                flightobj.setDestination(destinationPlace);
                flightobj.setDateandtime(dateAndTime);

                flightList.add(flightobj);
            }

            // Convert the flight list to JSON using Gson
            Gson gson = new Gson();
            String jsonArray = gson.toJson(flightList);

            // Close the database connection
            con.close();

            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching flight data: " + e.getMessage();
        }
    }

    @PutMapping("/updateFlight/{flightid}")
    public @ResponseBody String updateFlight(@PathVariable String flightid, @RequestBody String flightname) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a database connection
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");

            // Create an SQL UPDATE query with a parameterized statement
            String UPDATE_QUERY = "UPDATE flights SET flightname = ? WHERE flightid = ?";

            // Create a PreparedStatement and set the parameters
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, flightname);
            preparedStatement.setString(2, flightid);

            // Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();

            // Close the database connection
            con.close();

            if (rowsUpdated > 0) {
                return "Flight updated successfully.";
            } else {
                return "Flight not found or update failed.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating flight data: " + e.getMessage();
        }
    }
   
    @PostMapping("/insertFlightJdbc")
    public @ResponseBody String insertFlight(@RequestBody Flights flight) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");

            String insertQuery = "INSERT INTO flights (flightid, flightname, source, destination, dateandtime) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, flight.getFlightid());
            pstmt.setString(2, flight.getFlightname());
            pstmt.setString(3, flight.getSource());
            pstmt.setString(4, flight.getDestination());
            pstmt.setString(5, flight.getDateandtime());

            int rowsInserted = pstmt.executeUpdate();

            
            con.close();

            if (rowsInserted > 0) {
                return "Flight inserted successfully.";
            } else {
                return "Flight insertion failed.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error inserting flight data: " + e.getMessage();
        }
    }

	/*
	 * @PostMapping("/insertFlightHibernate") public @ResponseBody String
	 * insertFlightHibernate() { SessionFactory sessionFactory =
	 * getSessionFactory(null); Session session = sessionFactory.openSession();
	 * session.beginTransaction();
	 * 
	 * // Add new Employee object
	 * 
	 * FlightEntity flight = new FlightEntity(); //flight.setFlightid("ASDF4567");
	 * flight.setFlightname("ABCD"); flight.setSource("CHENNAI");
	 * flight.setDestination("HYDERABAD");
	 * flight.setDateandtime("09-09-2023 3.00 PM"); session.persist(flight);
	 * //session.save(emp);
	 * 
	 * session.getTransaction().commit();
	 * System.out.println("Generated flight id is : "+flight.getFlightid());
	 * //HibernateUtil.shutdown(); sessionFactory.close(); return "sdffd";
	 * 
	 * }
	 */

    
    @DeleteMapping("/deleteFlight/{flightid}")
    public @ResponseBody String deleteFlight(@PathVariable String flightid) {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");

            
            String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
            
            String deleteQuery = "delete from flights where flightid = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteQuery);
            pstmt.setString(1, flightid);
            pstmt.executeUpdate();
            con.close();
            return "Flight deleted successfully";
    	}catch (Exception e) {
            e.printStackTrace();
            return "Error inserting flight data: " + e.getMessage();
        }
    }
    
	
	  public static SessionFactory getSessionFactory(Class[] classes) { Metadata
	  metadata; StandardServiceRegistry standardRegistry = new
	  StandardServiceRegistryBuilder() .configure() .build();
	  
	  if(classes == null) { metadata = new MetadataSources(standardRegistry)
	  .getMetadataBuilder() .build(); } else { MetadataSources metadatasources =
	  new MetadataSources(standardRegistry); for(int index=0; index<classes.length;
	  index++) { metadatasources.addAnnotatedClass(classes[index]); } metadata =
	  metadatasources.getMetadataBuilder() .build();
	  
	  }
	  
	  SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
	  return sessionFactory;
	  
	  }
	 
    
	/*
	 * public static void flightBasic() {
	 * 
	 * //Session session = HibernateUtil.getSessionFactory().openSession();
	 * SessionFactory sessionFactory = getSessionFactory(null); Session session =
	 * sessionFactory.openSession(); session.beginTransaction();
	 * 
	 * // Add new Employee object FlightEntity flight = new FlightEntity();
	 * //flight.setFlightid("ASDF4567"); flight.setFlightname("ABCD");
	 * flight.setSource("CHENNAI"); flight.setDestination("HYDERABAD");
	 * flight.setDateandtime("09-09-2023 3.00 PM"); session.persist(flight);
	 * //session.save(emp);
	 * 
	 * session.getTransaction().commit();
	 * System.out.println("Generated flight id is : "+flight.getFlightid());
	 * //HibernateUtil.shutdown(); sessionFactory.close();
	 * 
	 * }
	 */
    
}
