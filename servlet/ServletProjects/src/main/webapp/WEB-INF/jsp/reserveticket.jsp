<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ticket Reservation</h1>
<form action = "/ServletProjects//MakeMyTripServlet/flightconfirm" method = "post">
<c:forEach var="flights" items="${flightlist}">
<input type = "text" value = <c:out value='${flights.flightid}'/>>
<input type = "text" value = <c:out value='${flights.flightname}'/>>
<input type = "text" value = <c:out value='${flights.source}'/>>
<input type = "text" value = <c:out value='${flights.destination}'/>>
<input type = "text" value = <c:out value='${flights.dateandtime}'/>>

</c:forEach>



<input type = "submit" value = "Click to Continue">
</form>
</body>
</html>