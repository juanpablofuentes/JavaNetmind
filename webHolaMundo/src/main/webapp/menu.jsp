<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurante Trifulcas</title>
</head>
<body>
	<h1>Menú del día</h1>
	<h2>Entrantes</h2>
	<%=request.getAttribute("entrantes")%>
	<h2>Segundo</h2>
	<%=request.getAttribute("segundos")%>
	<h2>Postres</h2>
</body>
</html>