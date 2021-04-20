<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
<a href="./tabla">Tabla multiplicar</a>
	<form>
		<div class="form-group">
			<label for="cadena">Introduce la cadena</label> <input type="text"
				class="form-control" placeholder="introduce cadena" name="cadena">
			<button type="submit" class="btn btn-primary">Enviar</button>
		</div>
		<%
		String pal = request.getAttribute("palindromo").toString();
		%>
		<h2><%=pal %></h2>
	</form>
</body>
</html>