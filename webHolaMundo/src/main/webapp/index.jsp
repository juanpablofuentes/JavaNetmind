<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lanza monedas</title>
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
	int num1 = (int) Math.floor(Math.random() * 2) + 1;
	int num2 = (int) Math.floor(Math.random() * 2) + 1;

	String moneda1 = num1 == 1 ? "cara" : "cruz";
	String moneda2 = num2 == 1 ? "cara" : "cruz";
	%>
	<h1>¡Lanza lamonedas!</h1>
	<p>
		<img src="img/<%=moneda1%>.png"> <img
			src="img/<%=moneda2%>.png">
	</p>
	<%
	if (num1 == num2) {
	%>
	<h2>Has ganado</h2>
	<%
	} else {
	%>
	<h2>Has perdido ¡looser!</h2>
	<%
	}
	%>
	<a href="index.jsp" class="btn btn-primary">Volver a tirar</a>

</body>
</html>