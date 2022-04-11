<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if tag</title>
</head>
<body>
	<c:if test="true">
		為真
	</c:if>
	<c:if test="false">
		為假
	</c:if>
	
	<%
		List list = new ArrayList();
		list.add("aaa");
		request.setAttribute("list", list);
		
		request.setAttribute("number", "3");
	%>
	
	<c:if test="${not empty list}">
		list有值
	</c:if>
	<br>
	<c:if test="${number % 2 != 0 }">
		${number } 奇數
	</c:if>
	<c:if test="${number % 2 == 0 }">
		${number } 偶數
	</c:if>
	
</body>
</html>