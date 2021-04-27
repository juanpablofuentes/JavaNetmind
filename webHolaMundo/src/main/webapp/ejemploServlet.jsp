<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Aquí voy a venir desde el servlet</h1>

	<h2>
		<c:out value="${nombre }" />
	</h2>
	<h2>
		Nombre:
		<c:out value="${autor.nombre }" />
	</h2>
	<h2>
		Apellido:
		<c:out value="${autor.apellido }" />
	</h2>
	<h2>
		Un círculo de radio
		<c:out value="${circulo.radio}" />
	</h2>
	<h2>
		Tiene un área de
		<c:out value="${circulo.area}" />
	</h2>
	<h2>
		Tiene un diámetro de
		<c:out value="${circulo.diametro()}" />
	</h2>
	<input type="text" name="nombre" value="${autor.nombre }">
	<c:if test="${circulo.area > 3}">
		<p>El área es mayor de 3</p>
	</c:if>

	<c:choose>
		<c:when test="${circulo.diametro() < 3}">
			<c:out value="Menor de 3" />
		</c:when>
		<c:when test="${circulo.diametro() < 6}">
			<c:out value="${iva} menor de 6" />
		</c:when>
		<c:otherwise>
			<c:out value="Mayor de 6" />
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" items="${datos }">
		<p>
			Dato
			<c:out value="Nº ${i}" />
		<p>
	</c:forEach>
</body>
</html>