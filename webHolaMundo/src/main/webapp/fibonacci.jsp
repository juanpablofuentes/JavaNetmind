<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fibonacci</title>
</head>
<body>
	<h1>Sucesi�n de fibonacci</h1>
	<p>
		Aqu� vas a ver los
		<%=request.getAttribute("terminos")%>
		primeros t�rminos de la sucesi�n de fibonacci
	</p>

	<h2><%=request.getAttribute("sucesion")%></h2>

	<form action="./fibonacci">
		<p>�Cuantos t�rminos quieres?</p>
		<input type="text" name="terminos"> <input type="submit">
	</form>
	
</body>
</html>