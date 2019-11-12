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
  width: 100%;
  length=50%;
  background-color: lightblue;

 
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
Register user=(Register)session.getAttribute("user");

if(user.getTypeOfUser().equalsIgnoreCase("employee")){     
%>

<center><h1>Add New Trip Details</h1></center>
<center>
<div class="ex1">
<form action="tour" method="post">
<center>
<table align="left" >
<tr>
<th>
<label>Tour Code</label>
</th>
<th>
<input type="text" name="code">
</th>
</tr>
<tr>
<th>
<label>Starting Point</label>
</th>
<th>
<select name="startPoint">
<option value="Bengaluru">Bengaluru</option>
<option value="Chennai">Chennai</option>
<option  value="Hyderabad">Hyderabad</option>
<option value="New Delhi">New Delhi</option>
<option  value="Kochi">Kochi</option>

</select> 
</th>
</tr>
<tr>
<th><label>Destination</label>
</th>
<th>
<select name="destination">
<option value="Bengaluru">Bengaluru</option>
<option value="Chennai">Chennai</option>
<option  value="Hyderabad">Hyderabad</option>
<option value="New Delhi">New Delhi</option>
<option  value="Kochi">Kochi</option>

</select>
</th>
</tr>
<tr>
<th>
<label>Start Date</label>
</th>
<th>
<input type="date" name="startDate">
</th>
</tr>
<tr>
<th>
<label>End Date</label>
</th>
<th>
<input type="date" name="endDate">
</th>
</tr>
<tr>
<th>
<label>Number of Days</label>
</th>
<th>
<input type="text" name="noOfDays">
</th>
</tr>
<tr>
<th>
<label>Number of Nights</label>
  </th>
  <th>
<input type="text" name="noOfNights">
</th>
</tr>
<tr>
<th>
<label>Place1</label>
</th>
<th>
<input type="text" name="place1">
</th>
</tr>
<tr>
<th>
<label>Place2</label>
</th>
<th>
<input type="text" name="place2">
</th>
</tr>
<tr>
<th>
<label>Place3</label>
</th>
<th>
<input type="text" name="place3">
</th>
</tr>
<tr>
<th>
<label>Cost of the Trip</label></th>
<th>
<input type="text" name="cost">
</th>
</tr>
<tr>
<th>
<input type="submit" value="Add Tour">
</th></tr>
</table></center>
</form>
</div><br/></center>
<% 
}
%>

<a href="viewTours.jsp">View Tours</a>

</body>
</html>