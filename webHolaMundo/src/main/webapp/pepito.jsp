<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>P�gina pepito</h1>
<%
String resultado=(String)request.getAttribute("resultado");
%>
<h2>Resultado <%=resultado %></h2>
</body>
</html>