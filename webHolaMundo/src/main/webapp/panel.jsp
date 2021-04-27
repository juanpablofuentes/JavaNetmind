<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tirar Monedas</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="zstyle.css">
</head>
<body>
	<%
	String nombre = (String)session.getAttribute("nombre");
	
	if (nombre==null){
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>
		Bienvenido
		<%=nombre%>
		a las utilidades maravillosas del ejercicio
	</h1>
	<h2>
		<a href="tabla.jsp">Tabla de multiplicar</a>
	</h2>
	<h2>
		<a href="mayor.jsp">Mayor y menor</a>
	</h2>
	<h2>
		<a href="palindromo.jsp">¿Es palíndromo?</a>
	</h2>
</body>
</html>