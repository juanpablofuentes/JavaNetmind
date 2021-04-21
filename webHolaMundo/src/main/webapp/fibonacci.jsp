<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fibonacci</title>
</head>
<body>
	<h1>Sucesión de fibonacci</h1>
	<p>
		Aquí vas a ver los
		<%=request.getAttribute("terminos")%>
		primeros términos de la sucesión de fibonacci
	</p>

	<h2><%=request.getAttribute("sucesion")%></h2>

	<form action="./fibonacci">
		<p>¿Cuantos términos quieres?</p>
		<input type="text" name="terminos"> <input type="submit">
	</form>
	
</body>
</html>