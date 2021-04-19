<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>calculadora</title>
</head>
<body>

<%!
boolean esPalindromo(String cadena){
	return true;
}

%>
	<%
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	
	
	if (num1!=null && !num1.equals("") && num1.chars().allMatch(Character::isDigit)) {
		out.print("Has enviado " + num1 + " y " + num2);
		int suma=Integer.parseInt(num1)+Integer.parseInt(num2);
		%>
		<h2>La suma es <%=suma %></h2>
		<%
	}
	%>

	<form>
		<input type="text" name="num1"> <input type="text" name="num2">
		<input type="submit">
	</form>

</body>
</html>