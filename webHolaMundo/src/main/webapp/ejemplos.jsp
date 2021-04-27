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
	String num = request.getParameter("numero");
	int numero = 10;
	if (num != null) {
		numero = Integer.parseInt(num);
	}
	for (int i = 0; i < numero; i++) {
		if (i % 2 == 0) {
	%>
	<h1>
		Número
		<%=i%></h1>
	<%
	}
	}
	%>
	<form>
		<input type="number" name="numero">
	</form>
</body>
</html>