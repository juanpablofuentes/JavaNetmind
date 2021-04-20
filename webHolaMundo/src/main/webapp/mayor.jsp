<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mayor y menor</title>
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
	String numero1 = request.getParameter("numero1");
	String numero2 = request.getParameter("numero2");
	numero1=numero1==null?"":numero1;
	%>

	<form>
		<div class="form-group">
			<label for="numero1">Número 1:</label> <input type="number"
				class="form-control" placeholder="Introduce el número"
				name="numero1" id="numero1" value="<%=numero1 %>">
		</div>
		<div class="form-group">
			<label for="numero2">Número 2:</label> <input type="number"
				class="form-control" placeholder="Introduce el número"
				name="numero2" value="<%=numero2!=null?numero2:"" %>">
		</div>
		<button type="submit" class="btn btn-primary">Enviar</button>
	</form>

	<%
	if (!numero1.equals("") && numero1.chars().allMatch(Character::isDigit) && numero2 != null
			&& !numero2.equals("") && numero2.chars().allMatch(Character::isDigit)) {
		int num1 = Integer.parseInt(numero1);
		int num2 = Integer.parseInt(numero2);

		if (num2 > num1) {
			num1 = num2;
		}
	%>
	<h2>
		El número mayor es
		<%=num1%></h2>
	<%
	}
	%>
</body>
</html>