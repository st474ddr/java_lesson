<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foreach tag</title>
</head>
<body>
<c:forEach begin="1" end="10" var="i" step="1">
	${i }<br>
</c:forEach>
	
	
	<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
	${i } <h3>${s.index }</h3> <h4>${s.count }</h4><br>
	</c:forEach>
	
	<hr>
	<%
		List list = new ArrayList();
		list.add("aaa");
		list.add("abb");
		list.add("ccc");
		request.setAttribute("list", list);

	%>
	
	<c:forEach items="${list }" var="str" varStatus="s">
	${s.index } ${s.count } ${str } <br>
		
	</c:forEach>
	
</body>
</html>