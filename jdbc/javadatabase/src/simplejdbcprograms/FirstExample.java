package simplejdbcprograms;
import java.sql.*;
public class FirstExample {
	   static final String DB_URL = "jdbc:mysql://localhost:3306/sampleschema";
	   static final String USER = "root";
	   static final String PASS = "root";
	   static final String QUERY = "select tbl_stud.studeptid , tbl_stud.name\r\n"
	   		+ "from sampleschema.tbl_stud\r\n"
	   		+ "RIGHT JOIN sampleschema.tbl_dept\r\n"
	   		+ "ON sampleschema.tbl_stud.studeptid = sampleschema.tbl_dept.deptid;";
	   


	   public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	           
	            System.out.println(rs.getInt("studeptid"));
	            
	         }
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	}