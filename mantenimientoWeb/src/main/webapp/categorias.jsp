<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento web</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Patrick+Hand&display=swap"
	rel="stylesheet">
<link href="css/estilo.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Mantenimiento de Categorías</h1>
			<p>Aquí podrá usted hacer el mantenimiento de todas las
				categorías</p>
		</div>
		<a href="categorias?accion=nueva">Añadir una categoría</a>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="categoria" items="${categorias}">
				<tr>
					<td><c:out value="${categoria.category_id}"/></td>
					<td><c:out value="${categoria.name}"/></td>
					<td><c:out value="${categoria.last_update}"/></td>
					<td><a href="categorias?accion=borrar&id=<c:out value="${categoria.category_id}"/>">Eliminar</a>
					 | <a href="categorias?accion=editar&id=<c:out value="${categoria.category_id}"/>">Editar</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>