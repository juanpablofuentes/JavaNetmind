<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>Editar categoría</h1>
			<p>Introduzca los datos de la categoría</p>
		</div>

		<form action="./categorias?accion=actualizar" method="post">
			<div class="form-group">
				<label for="nombre">Id:</label> <input type="text"
					class="form-control" readonly placeholder="Introduzca el nombre" name="id" value="${categoria.category_id }">
			</div>
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" placeholder="Introduzca el nombre" name="nombre" value="${categoria.name }">
			</div>
			
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>

	</div>
</body>
</html>