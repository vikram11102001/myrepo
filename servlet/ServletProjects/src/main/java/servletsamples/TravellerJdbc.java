package servletsamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TravellerJdbc {

	public static void main(String[] args) {
		
		
		
		
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
	        
	        String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
		    Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
		    Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM traveller");
	        while(rs.next()) {
	        	String travellerId = rs.getString("travellerid");
	        	String firstName = rs.getString("firstname");
	        	String lastName = rs.getString("lastname");
	        	String passWord = rs.getString("password");
	        	
	        }

		}catch(SQLException e1) {
			e1.printStackTrace();
		}

	}

}
