<%@page import="com.training.dao.TravelDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.entity.Register,java.util.List,com.training.entity.Travel"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
div.ex1 {
  margin: auto;
  width: 60%;

  padding: 10px;
}

div.ex2 {
  max-width:1000px;
  margin: auto;
  
}

table,td {
  border: 1px solid black;
  cellspacing:20px;
  cellpadding:10px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><img src="images/logo.jpg"></center>
<% 
TravelDao dao=new TravelDao();
List<Travel> tourList=null;
tourList=dao.findAll();

request.setAttribute("tourList", tourList);
%>
<br>
<div class="ex2">
<table>
<tr>
<th>Tour Code</th>
<th>Starting Point</th>
<th>Destination</th>
<th>Start Date</th>
<th>End Date</th>
<th>Place1</th>
<th>Place2</th>
<th>Place3</th>
<th>Number of Days</th>
<th>Number Of Nights</th>
<th>Cost of the Trip</th>
</tr>

<c:forEach var="tours" items="${requestScope.tourList}">
<tr>
<th><h3>${tours.code}</h3></th>
<th><h3>${tours.startPoint}</h3></th>
<th><h3>${tours.destination}</h3></th>
<th><h3>${tours.startDate}</h3></th>
<th><h3>${tours.endDate}</h3></th>
<th><h3>${tours.place1}</h3></th>
<th><h3>${tours.place2}</h3></th>
<th><h3>${tours.place3}</h3></th>
<th><h3>${tours.noOfDays}</h3></th>
<th><h3>${tours.noOfNights}</h3></th>
<th><h3>${tours.cost}</h3></th>
</tr>
</c:forEach>

</table>
</div>

<center>
<div>
<h3>Search Tours</h3>

<form action="tour" method="get">
<table>
<tr><th>
<label>Start Point</label></th>
<th><select name="startPoint">
<option value="Bengaluru">Bengaluru</option>
<option value="Chennai">Chennai</option>
<option  value="Hyderabad">Hyderabad</option>
<option value="New Delhi">New Delhi</option>
<option  value="Kochi">Kochi</option>

</select> </th></tr>
<tr><th>
<label>Destination</label></th>
<th><th><select name="destination">
<option value="Bengaluru">Bengaluru</option>
<option value="Chennai">Chennai</option>
<option  value="Hyderabad">Hyderabad</option>
<option value="New Delhi">New Delhi</option>
<option  value="Kochi">Kochi</option></th></tr>
<input type="submit" value="Find Tour">
</table>
</form>
</div>
</center><br/>
<div class="ex2">
<table>
<tr>
<th>Tour Code</th>
<th>Starting Point</th>
<th>Destination</th>
<th>Start Date</th>
<th>End Date</th>
<th>Place1</th>
<th>Place2</th>
<th>Place3</th>
<th>Number of Days</th>
<th>Number Of Nights</th>
<th>Cost of the Trip</th>
</tr>
<tr>
<th><h3>${tour.code}</h3></th>
<th><h3>${tour.startPoint}</h3></th>
<th><h3>${tour.destination}</h3></th>
<th><h3>${tour.startDate}</h3></th>
<th><h3>${tour.endDate}</h3></th>
<th><h3>${tour.place1}</h3></th>
<th><h3>${tour.place2}</h3></th>
<th><h3>${tour.place3}</h3></th>
<th><h3>${tour.noOfDays}</h3></th>
<th><h3>${tour.noOfNights}</h3></th>
<th><h3>${tour.cost}</h3></th>
<form action="book"  method="get">
<th><input type="submit" name="book" value="Book"></th>
</form>




</tr>
</table>
</div>
<center><a href="billing.jsp">Go to Billing</a></center>
</body>
</html>
