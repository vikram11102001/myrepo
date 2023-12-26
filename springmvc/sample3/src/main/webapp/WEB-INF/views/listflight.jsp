<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h1>Flights</h1>
	<c:forEach var="flights" items="${flightlist}">
	<%-- <a href="/fc"><c:out value="${flights.flightid}" /></a> --%>
	<%-- <a href="/flightbooking?flightid=${flights.flightid}&flightName=${flights.flightname}&source=${flights.source}&destination=${flights.destination}&dateTime=${flights.dateandtime}">
    
</a> --%>
	
	 <%-- <a href="/flightbooking?id=<c:out value='${flights.flightid}' />" ></a>
	
 
    <a href <c:out value="${flights.flightid}" />
 
    <a href = "/flightbooking?name=<c:out value='${flights.flightname}' />"></a>
 
    <a href = "/flightbooking?source=<c:out value='${flights.source}' />"></a>
	<a href = "/flightbooking?destination=<c:out value='${flights.destination}' />"></a>
	<a href = "/flightbooking?dateandtime=<c:out value='${flights.dateandtime}' />"></a> --%>
	<a href="/ServletProjects//MakeMyTripServlet/flightbooking?flightid=<c:out value='${flights.flightid}' />" ><c:out value='${flights.flightid}' /></a>
	<c:out value='${flights.flightname}' />
	<c:out value='${flights.source}' />
	<c:out value='${flights.destination}' />
	<c:out value='${flights.dateandtime}' />
	<br>
 
</c:forEach>
<!-- <a href = /ServletProjects//MakeMyTripServlet/flightbooking></a> -->
</body>
</html>