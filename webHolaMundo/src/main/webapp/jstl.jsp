<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejemplos jstl</title>
</head>
<body>

	<c:out value="hola que tal" />
	<!-- importe es un atributo que viene del servlet -->

	<c:out value="${importe}" />
	<c:out value="${cantidad}" />
	<c:out value="${producto}" />


	<!-- String nomobre="Eva pi" -->
	<c:set value="Eva pi" var="nombre" />
	<!-- nombre="Juan" -->
	<c:set value="Juan" var="nombre" />

	<c:out value="${nombre}" />

	<!-- int iva=importe*.21 -->
	<c:set value="${importe*.21}" var="iva" />

	<c:out value="${iva}" />

	<c:if test="${iva > 100}">
		<p>¡Que caro!</p>
	</c:if>

	<c:choose>
		<c:when test="${iva < 100}">
			<c:out value="${iva} menor de 100" />
		</c:when>
		<c:when test="${iva < 200}">
			<c:out value="${iva} menor de 200" />
		</c:when>
		<c:otherwise>
			<c:out value="${iva} mayor de 200" />
		</c:otherwise>
	</c:choose>


	<c:forEach var="i" items="1,4,5,6,7,8,9">
    Item <c:out value="Nº ${i}" />
		<p>
	</c:forEach>

	<c:forEach var="alumno" items="${alumnos}">
		<p>
			Alumno
			<c:out value="${alumno}" />
		</p>
	</c:forEach>

	<c:forEach var="i" items="${notas }">
		<p>
			Notas
			<c:out value="${i}" />
		</p>
	</c:forEach>
	<c:out value="${autor}" />
	<!-- Al acceder a la propiedad nombre la librería busca si ese objeto tiene un método
	getNombre si lo tiene bien y si no error
	 -->
	<c:out value="${autor.nombre}" />
	<c:out value="${autor.apellido}" />

</body>
</html>