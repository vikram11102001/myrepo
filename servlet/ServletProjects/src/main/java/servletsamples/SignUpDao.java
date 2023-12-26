package servletsamples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDao {
	
	public void saveSignUp(String travellerid, String firstname, String lastname, String password) {
		String travellerID = travellerid;
		String firstName = firstname;
		String lastName = lastname;
		String passWord = password;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
		    Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
		    String insertQuery = "insert into traveller(travellerid, firstname, lastname, password) values(?, ?, ?, ?)";
		    PreparedStatement pstmt = con.prepareStatement(insertQuery);
		    
		    pstmt.setString(1, travellerID);
	        pstmt.setString(2, firstName);
	        pstmt.setString(3, lastName);
	        pstmt.setString(4, passWord);
	        pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//SignUpDao dao1 = new SignUpDao();
			//dao1.saveSignUp();
	}

}
