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
	// built-in object
	String contextPath = request.getContextPath();
	out.println(contextPath);
	out.println("hello jsp");
	int i = 3;
	%>
	
	<% response.getWriter().write("response"); %>
	
	<%!int i = 5;%>
	<%= i %>
</body>
</html>