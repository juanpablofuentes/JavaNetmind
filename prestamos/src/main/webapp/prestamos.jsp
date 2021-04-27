<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento prestamos</title>
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
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
	<h1>Lista de préstamos</h1>
	<a href="./prestamos?accion=nuevo" class="btn btn-primary">Nuevo préstamo</a>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Titulo</th>
				<th>Fecha</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="prestamo" items="${prestamos}">
				<tr>
					<td><c:out value="${prestamo.idprestamos}" /></td>
					<td><c:out value="${prestamo.nombre}" /></td>
					<td><c:out value="${prestamo.titulo}" /></td>
					<td><c:out value="${prestamo.fecha}" /></td>
					<td><a href="./prestamos?accion=editar&id=${prestamo.idprestamos}">Editar</a> | 
					<a href="./prestamos?accion=borrar&id=${prestamo.idprestamos}">Borrar</a> </td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	</div>
</body>
</html>