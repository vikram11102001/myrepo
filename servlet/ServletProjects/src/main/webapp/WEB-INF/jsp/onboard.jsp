<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
</head>
<body>
<h1>Welcome User!!!</h1>
<form action = "/ServletProjects//MakeMyTripServlet/flightdisplay" method = "post">
<label for = "travellerid">Traveller ID</label>
<input type = "text" name = "travellerid"><br/>
<label for = "firstname">First Name</label>
<input type="text" name="firstname"><br/>  
<label for = "lastname">Last Name</label>
<input type="text" name="lastname"><br/>  
<label for = "password">Password</label>
<input type="password" name="password"><br/>

<input type = 'submit' value = "SignUp">
</form>
</body>
</html>