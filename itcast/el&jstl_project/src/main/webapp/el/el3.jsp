<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page import="domain.User"%>
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
	User user = new User();
	user.setName("gege");
	user.setAge(12);
	user.setBirthday(new Date());

	request.setAttribute("u", user);

	List list = new ArrayList();
	list.add("aaaaa");
	list.add("bbbb");
	list.add(user);
	request.setAttribute("list", list);

	Map map = new HashMap();
	map.put("sname", "pp");
	map.put("gender", "male");
	map.put("user", user);

	request.setAttribute("map", map);
	%>

	<h3>object取值</h3>
	${requestScope.u.name }
	<br> ${u.age }
	<br> ${u.birthday }
	<br> ${u.birString }
	<br>

	<h3>list取值</h3>
	${list }
	<br> ${list[0] }
	<br> ${list[1] }
	<br> ${list[10] }
	<br> ${list[2].name }
	<br>

	<h3>map取值</h3>
	${map.gender }
	<br> ${map["gender"] }
	<br> ${map.user.name }

	<h3>empty</h3>
	<%
	String str = null;
	request.setAttribute("str", str);
	%>
	${empty str2 }
	${empty str }


</body>
</html>