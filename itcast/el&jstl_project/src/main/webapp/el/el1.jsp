<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${3 > 4}
	
	\${3 > 4 }
	
	<hr>
	<h3>計算</h3>
	${3 + 4 }<br>
	${3 / 4 }<br>
	${3 div 4 }<br>
	<h3>比較</h3>
	${3 == 4 }<br>
	<h3>邏輯</h3>
	$(3 > 4 and 3 < 4)<br>
	
	
</body>
</html>