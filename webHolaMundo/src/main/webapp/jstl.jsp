<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="hola que tal" />
	<!-- importe es un atributo que viene del servlet -->
	<%=request.getAttribute("importe") %>
	<c:out value="${importe}" />

	<c:set value="Eva pi" var="nombre" />

	<c:out value="${nombre}" />

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
</body>
</html>