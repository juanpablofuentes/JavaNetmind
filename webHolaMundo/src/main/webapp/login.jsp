<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
<!-- Recuperar el nombre y la contraseña. Si es admin admin ir a otra página -->

<%
String nombre=request.getParameter("nombre");
String pwd=request.getParameter("pwd");

if (nombre!=null && pwd!=null && nombre.equals("admin") && pwd.equals("admin")){
	response.sendRedirect("panel.jsp");
}
%>

 <form  method="post">
  <div class="form-group">
    <label for="nombre">Nombre:</label>
    <input type="text" class="form-control" placeholder="Introduce nombre" name="nombre" id="nombre">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Introduce contraseña" name="pwd">
  </div>
  
  <button type="submit" class="btn btn-primary">Enviar</button>
</form> 
	
</body>
</html>