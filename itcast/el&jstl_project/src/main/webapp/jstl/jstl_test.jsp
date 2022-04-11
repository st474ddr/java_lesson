<%@page import="domain.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<%
	List list = new ArrayList();
	list.add(new User("gg", 22, new Date()));
	list.add(new User("pp", 24, new Date()));
	list.add(new User("qq", 25, new Date()));

	request.setAttribute("list", list);
	%>

	<table border="1" width="500">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>birthday</th>
		</tr>
	
	<c:forEach items="${list }" var="user" varStatus="s">
		<tr>
			<td>${s.count }</td>
			<td>${user.name }</td>
			<td>${user.age }</td>
			<td>${user.birString }</td>
		</tr>

	</c:forEach>
</table>
</body>
</html>