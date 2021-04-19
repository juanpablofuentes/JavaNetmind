<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cesta</title>
</head>
<body>
	<%
	String nombre = (String) session.getAttribute("usuario");
	out.print("<h1>Cesta de " + nombre + "</h1>");
	%>
	
	<h2><%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm")) %></h2>
	
	<%@ include file="footer.jsp" %>  
	
	<jsp:include page="footer.jsp" />  
</body>
</html>