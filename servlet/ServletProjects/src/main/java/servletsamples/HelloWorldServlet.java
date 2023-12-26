package servletsamples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet/*")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: venkat testing").append(request.getContextPath());
		System.out.println("tesing inside hws");
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo is " + pathInfo);
		response.getWriter().append("testing wild card Served at: ").append(request.getContextPath());
		int i =1;
		if(i==0) {
			return;
		}
		String destination = "/WEB-INF/jsp/onboard.jsp";
		if(pathInfo.equals("/SignUp")){
			System.out.println("Going to onboard.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
		}else if(pathInfo.equals("/flightbooking")) {
			System.out.println("Going to reserveticket.jsp");
			destination = "/WEB-INF/jsp/reserveticket.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
		}else if(pathInfo.equals("/flightconfirm")) {
	    	System.out.println("Going to confirmation.jsp");
			destination = "/WEB-INF/jsp/confirmation.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
		}else {
			System.out.println("Going to exit.jsp");
			destination = "/WEB-INF/jsp/exit.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
				
		}
			
		String b = request.getParameter("travellerid");
		System.out.println(b);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		try {
		
	      // Getting the connection
	      String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
	      System.out.println("Connection established......");

	      // Creating a Prepared Statement
			
		  String query = "INSERT INTO TRAVELLER VALUES(?)"; 
		  PreparedStatement pstmt = con.prepareStatement(query);
			 

	      // Inserting data for the first employee
	      pstmt.setString(1, b);
	      
	      pstmt.executeUpdate();

	      // Inserting data for the second employee
	      

	      // Inserting data for the third employee
	      
	      System.out.println("Rows inserted ....");
	      String QUERY = "select travellerid from traveller";
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(QUERY);
          ArrayList travelleridarraylist = new ArrayList();
 	         // Extract data from result set
 	         while (rs.next()) {
 	            // Retrieve by column name
 	            String v = rs.getString("travellerid");
 	            		
 	           travelleridarraylist.add(v);
 	            
 	         }
         
          
        //loop through resultset and add elements in departmentArrayList 
        request.setAttribute("travellerid", travelleridarraylist);
          

	      pstmt.close();
	      con.close();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		//You can also connect to DB, save the value of dept in a table.
		RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
		String name = "john";
		//You can also connect to DB, get the value of name from SQL query and pass it to JSP page.
		
		request.setAttribute("name", name);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		try {
			Object pathInfo = null;
			if (pathInfo.equals("/flightdisplay")){
				System.out.println("Going to listflights.jsp");
			    String destination = "/WEB-INF/jsp/listflight.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
				dispatcher.forward(request, response);
				String travellerId = request.getParameter("travellerid");
		    	String firstName = request.getParameter("firstname");
		    	String lastName = request.getParameter("lastname");
		    	String passWord = request.getParameter("password");
		     
			}
			doGet(request, response);
			} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

}
