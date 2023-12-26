package simplejdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTimeExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sampleschema";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "INSERT INTO transactions (txnid, txndate, txntime, amount, merchantname, descp, status, cardnumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, 2);
                preparedStatement.setString(2, "2002-05-16");
                preparedStatement.setString(3, "12:30");
                preparedStatement.setString(4, "56.2300");
                preparedStatement.setString(5, "Ram");
                preparedStatement.setString(6, "Transaction successful");
                preparedStatement.setString(7, "approval");
                preparedStatement.setString(8, "1234 2678 2396");

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleschema","root", "root");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transactions");
            System.out.println("txnid  txndate    amount");
            
            while (rs.next()) {
               int txnid = rs.getInt("txnid");
               String txndate = rs.getString("txndate");
               String amount = rs.getString("amount");
               System.out.println(txnid+"   "+txndate+"    "+amount);
            }
         } catch(SQLException e) {
            System.out.println("SQL exception occured" + e);
         }
    }
}
