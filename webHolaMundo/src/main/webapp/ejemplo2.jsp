
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String cadena=request.getParameter("cadena");

if (cadena==null){
	cadena=" ";
}

if (cadena.substring(0,1).equals("s") || cadena.substring(cadena.length()-1).equals("s")){
	%>
	<h2>La cadena empieza o acaba por s</h2>
	<%
}
%>

	<form>
		<input type="text" name="cadena"> <input type="submit">
	</form>
</body>
</html>