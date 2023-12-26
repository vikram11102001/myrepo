	package simplejdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {
   public static void main(String args[]) throws SQLException {
      // Registering the Driver
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

      // Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
      System.out.println("Connection established......");

      // Creating a Prepared Statement
      String query = "INSERT INTO employee(Name, Salary, Location) VALUES (?, ?, ?)";
      PreparedStatement pstmt = con.prepareStatement(query);

      
      // Inserting data for the first employee
      pstmt.setString(1, "Vikram");
      pstmt.setInt(2, 3000);
      pstmt.setString(3, "Hyderabad");
      pstmt.executeUpdate();

      // Inserting data for the second employee
      pstmt.setString(1, "Varrun");
      pstmt.setInt(2, 4000);
      pstmt.setString(3, "Vishakhapatnam");
      pstmt.executeUpdate();

      // Inserting data for the third employee
      
      System.out.println("Rows inserted ....");

      pstmt.close();
      con.close();
   }
}
