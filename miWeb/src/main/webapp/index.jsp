<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pruebas JSP</title>
</head>
<body>
	<h1>Hola ¿Qué tal?</h1>
	<p>Esto es una página jsp</p>

	<!-- Imprimo con la función out de JSP -->
	<p>
		<%
		out.print("Esto es código JSP");
		%>
	</p>

	<!-- %= es un atajo si solo quiero imprimir -->
	<p><%="Esto es también"%></p>

	<!-- Uso clases de java -->
	<h3><%=java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm"))%></h3>


	<!-- Declaraciones -->
	<%!String nombre = "Ana Pi";

	String saludo(String nombre) {
		return "Hola " + nombre;
	}%>

	<!-- Uso lo declarado -->

	<p><%=saludo(nombre)%></p>
	<p><%=saludo("Juan Buj")%></p>

	<form action="procesar.jsp" method="post">
		<input type="text" name="nombre"> <input type="submit"
			value="Probar"><br />
	</form>
</body>

</html>