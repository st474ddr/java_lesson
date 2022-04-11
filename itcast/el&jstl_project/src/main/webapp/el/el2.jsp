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
	session.setAttribute("name", "qq");
	request.setAttribute("name", "gg");
		session.setAttribute("age", "15");
		
	%>
	
	
	<h3>el取值</h3>
	${requestScope.name }
	${sessionScope.age }
</body>
</html>