<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de multiplicar</title>
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
String numero=request.getParameter("numero");
%>

 <form>
  <div class="form-group">
    <label for="numero">Número:</label>
    <input type="number" class="form-control" placeholder="Introduce el número" name="numero"
    value="<%=numero!=null?numero:"" %>" >
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form> 
	
<%

if (numero!=null && !numero.equals("") && numero.chars().allMatch(Character::isDigit)){
	int num=Integer.parseInt(numero);
	for(int i=1;i<=10;i++){
	//	out.println("<p>"+i+" x "+num+" = "+(i*num)+"</p>");
		%>
		<p><%=i%> x <%=num %> = <%=(i*num) %></p>
		<%
	}
}

%>
</body>
</html>