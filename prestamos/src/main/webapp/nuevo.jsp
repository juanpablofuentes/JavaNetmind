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
		<h1>Nuevo préstamo</h1>
		<form action="./prestamos?accion=insertar" method="post">
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" placeholder="Nombre" name="nombre">
			</div>
			<div class="form-group">
				<label for="titulo">Título:</label> <input type="text"
					class="form-control" placeholder="Titulo" name="titulo">
			</div>
			<div class="form-group">
				<label for="fecha">Fecha:</label> <input type="text"
					class="form-control" placeholder="Fecha" name="fecha">
			</div>
			<input type="submit"/>
		</form>
	</div>
</body>
</html>