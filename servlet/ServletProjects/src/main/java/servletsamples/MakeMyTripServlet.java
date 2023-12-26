package servletsamples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MakeMyTripServlet
 */
@WebServlet("/MakeMyTripServlet/*")
public class MakeMyTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeMyTripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		String destination = "/WEB-INF/jsp/onboard.jsp";
		if(pathInfo.equals("/SignUp")){
			System.out.println("Going to onboard.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);

		}else if(pathInfo.equals("/flightbooking")) {
			System.out.println("Going to reserveticket.jsp");
			destination = "/WEB-INF/jsp/reserveticket.jsp";
			String flightId = request.getParameter("flightid");
	    	String flightName = request.getParameter("flightname");
	    	String sourceplace = request.getParameter("source");
	    	String destinationplace = request.getParameter("destination");
	    	String dateandtime = request.getParameter("dateandtime");
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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			
			String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
			Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
			String pathInfo = request.getPathInfo();
			
			if (pathInfo.equals("/flightdisplay")){
				System.out.println("Going to listflights.jsp");
			    String destination = "/WEB-INF/jsp/listflight.jsp";
			    
				String travellerId = request.getParameter("travellerid");
		    	String firstName = request.getParameter("firstname");
		    	String lastName = request.getParameter("lastname");
		    	String passWord = request.getParameter("password");
		        String insertQuery = "insert into traveller(travellerid, firstname, lastname, password) values(?, ?, ?, ?)";
		        PreparedStatement pstmt = con.prepareStatement(insertQuery);
		        
		        pstmt.setString(1, travellerId);
		        pstmt.setString(2, firstName);
		        pstmt.setString(3, lastName);
		        pstmt.setString(4, passWord);
		        pstmt.executeUpdate();
		        
		        String QUERY = "select * from flights";
				
				
		        Statement stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(QUERY);
		        ArrayList flightlist = new ArrayList();
		        
		       /* while(rs.next()) {
		        	System.out.println(rs.getString("flightid"));
		        	System.out.println(rs.getString("flightname"));
		        	System.out.println(rs.getString("source"));
		        	System.out.println(rs.getString("destination"));
		        	System.out.println(rs.getString("dateandtime"));
		        }*/
		        
		        while (rs.next()) {
		        	System.out.println("1");
	 	            // Retrieve by column name
	 	            String flightId = rs.getString("flightid");
	 	            String flightName = rs.getString("flightname");
	 	            String sourceplace = rs.getString("source");
	 	            String destinationplace = rs.getString("destination");
	 	            String dateandtime = rs.getString("dateandtime");
	 	            System.out.println("2");
		           
	 	            Flights flightobj = new Flights();
	 	            
	 	            flightobj.setFlightid(flightId);
	 	            flightobj.setFlightname(flightName);
	 	            flightobj.setSource(sourceplace);
	 	            flightobj.setDestination(destinationplace);
	 	            flightobj.setDateandtime(dateandtime);
	 	            
	 	            System.out.println("3");
	 	            
	 	            
	 	            
	 	            
	 	           
	 	           flightlist.add(flightobj);
	 	           System.out.println("4");
	 	            
	 	            
	 	        
		        }
	 	          request.setAttribute("flightlist", flightlist);
					RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
					dispatcher.forward(request, response);

		        
			}
			
			
			/*
			 * if(pathInfo.equals("/flightbooking")) {
			 * System.out.println("Going to reserveticket.jsp"); String destination =
			 * "/WEB-INF/jsp/reserveticket.jsp"; String flightId =
			 * request.getParameter("flightid"); String flightName =
			 * request.getParameter("flightname"); String sourceplace =
			 * request.getParameter("source"); String destinationplace =
			 * request.getParameter("destination"); String dateandtime =
			 * request.getParameter("dateandtime"); String bookedtravellerid =
			 * request.getParameter("travellerid"); String bookedflightid =
			 * request.getParameter("flightid"); RequestDispatcher dispatcher =
			 * request.getRequestDispatcher(destination); dispatcher.forward(request,
			 * response); Object flightlist = null; request.setAttribute("flightlist",
			 * flightlist);
			 * 
			 * RequestDispatcher dispatcher1 = request.getRequestDispatcher(destination);
			 * dispatcher1.forward(request, response);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * }
			 */
			
			
			
			
			/*
			 * } catch (ServletException | IOException e) { // TODO Auto-generated catch
			 * block e.printStackTrace();
			 */
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

}
