<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.training.entity.Travel,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
<%
List<Travel> name=(List<Travel>)session.getAttribute("bookingList");
request.setAttribute("list", name);
out.print(name); 
%>
<c:out value="name"/>
<c:forEach var="tours" items="${requestScope.list}">
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

</body>
</html>