<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>¿Es palíndromo?</title>
<!-- Latest compiled and minified CSS -->
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
<link rel="stylesheet" type="text/css" href="zstyle.css">
</head>
<body>

	<%
	String cadena = request.getParameter("cadena");
	
	if (cadena != null) {
		if (esPalindromo(cadena)) {
	%>
	<h2>
		La cadena <b><%=cadena%></b> es un palíndromo
	</h2>
	<%
	} else {
	%>
	<h2>
		Lo siento, la cadena <b><%=cadena%></b> NO es un palíndromo
	</h2>
	<%
	}

	String mensaje = "";
	if (!esPalindromo(cadena)) {
	mensaje = " NO ";
	}
	%>
	<h2>
		La cadena <b><%=cadena%></b>
		<%=mensaje%>
		es un palíndromo
	</h2>
	<%
	}
	%>

	<form>
		<div class="form-group">
			<label for="numero1">Introduce la cadena:</label> <input type="text"
				class="form-control" placeholder="Introduce la cadena" name="cadena"
				value="<%=cadena != null ? cadena : ""%>">
		</div>
		<button type="submit" class="btn btn-primary">Enviar</button>
	</form>

	<%!boolean esPalindromo(String cadena) {
		cadena = normalizar(cadena);
		StringBuilder foo = new StringBuilder(cadena);
		return cadena.equals(foo.reverse().toString());
	}

	// He creado una función normalizar para otros caracteres
	String normalizar(String cadena) {
		return cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace("ü", "u").replace(" ", "").replace(".", "").replace(",", "");
	}%>
</body>
</html>