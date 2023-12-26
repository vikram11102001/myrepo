package simplejdbcprograms;
import java.sql.*;

public class ReadContentsFromTable {
	public static void main(String[] args) {
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
