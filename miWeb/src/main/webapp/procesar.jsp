<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recuperar datos</title>
</head>
<body>
<h1>${param.nombre }</h1>
	<%
	String nombre = request.getParameter("nombre");
	out.print("Hola " + nombre);
	
	session.setAttribute("usuario",nombre);
	
	if (nombre.equals("domiciano")){
		response.sendRedirect("https://es.wikipedia.org/wiki/Domiciano");
	}
	%>
	<a href="cesta.jsp">Ir a cesta</a>
</body>
</html>