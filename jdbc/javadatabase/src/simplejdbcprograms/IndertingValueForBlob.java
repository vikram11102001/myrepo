package simplejdbcprograms;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class IndertingValueForBlob {
   public static void main(String args[]) throws Exception{
      //Registering the Driver
	   System.out.println("1");
      //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      System.out.println("2");
      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
      System.out.println("Connection established......");

      //Inserting values
      String query = "INSERT INTO MyTable(name,image) VALUES (?, ?)";
      PreparedStatement pstmt = con.prepareStatement(query);
      pstmt.setString(1, "sample_image4");
      FileInputStream fin = new FileInputStream("C:\\Users\\karth\\OneDrive\\Pictures\\flower.jpg");
      pstmt.setBinaryStream(2, fin);
      pstmt.execute();
      System.out.println("Record inserted .....");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from Mytable where name = 'sample_image3';");
      int i = 1;
      System.out.println("Contents of the table are: ");
      
      while(rs.next()) {
         System.out.println(rs.getString("Name"));
         Blob blob = rs.getBlob("Image");
         byte byteArray[] = blob.getBytes(1,(int)blob.length());
         FileOutputStream outPutStream = new
         FileOutputStream("C:\\Users\\karth\\OneDrive\\Pictures\\flower1.jpg");
         outPutStream.write(byteArray);
         System.out.println("");
         System.out.println();
         i++;
      }
   }
}   
