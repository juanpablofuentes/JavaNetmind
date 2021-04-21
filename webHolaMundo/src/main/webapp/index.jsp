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
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<%
	int num1 = (int) Math.floor(Math.random() * 2) + 1;
	int num2 = (int) Math.floor(Math.random() * 2) + 1;

	String moneda1 = num1 == 1 ? "cara" : "cruz";
	String moneda2 = num2 == 1 ? "cara" : "cruz";
	System.out.print(moneda1);
	%>
	<h1>
		Juego de las monedas <img src="img/cara.png" />
	</h1>
	<h1>¡Lanza la monedas!</h1>
	<a href="./menu">O pincha aquí si quieres ver el delicioso menú del
		día</a>
	<p>
		<%
		if (num1 == 1) {
		%>
		<img src="img/cara.png">
		<%
		} else {
		%>
		<img src="img/cruz.png">
		<%
		}
		%>
		<img src="img/<%=moneda2%>.png">
	</p>
	<%
	String mensaje = "";
	if (num1 == num2) {
		mensaje = "Has ganado";
	} else {
		mensaje = "Has perdido";
	}
	%>
	<h2><%=mensaje%></h2>
	<form action="./menu" method="post">
		<input type="submit">
	</form>
	<a href="index.jsp" class="btn btn-primary">Volver a tirar</a>
	<script src="js/codigo.js"></script>
</body>
</html>