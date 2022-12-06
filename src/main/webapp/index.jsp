<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!</h1>
	<form action ="<%=request.getContextPath() %>/hello" method="post">
		<input type ="text" placeholder ="Enter name" name = "uname"/><br>
		<input type = "submit" value = "Click"/>
	</form><br>
	<!--  
	<a href = "<%=request.getContextPath() %>/hello">Click here to invoke the servlet</a>
	-->
</body>
</html>