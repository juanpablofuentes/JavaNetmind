<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${'Welcome to javaTpoint'}" />
	<form action="./Controller" method="post">
		Name:<input type="text" name="name"><br> Password:<input
			type="password" name="password"><br> <input
			type="submit" value="login">
	</form>

	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/sakila" user="root" password="" />

	<sql:query dataSource="${db}" var="rs">  
SELECT * from Actor;  
</sql:query>

	<table border="2" width="100%">
		<tr>
			<th>Student ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="table" items="${rs.rows}">
			<tr>
				<td><c:out value="${table.actor_id}" /></td>
				<td><c:out value="${table.first_name}" /></td>
				<td><c:out value="${table.last_name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>