<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="loginServlet" method="post">
		<table>
			<tr>
				<td>帳號</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密碼</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>驗證碼</td>
				<td><input type="text" name="checkCode"></td>
			</tr>
			<tr>
				<td colspan="2"><img id="img" src="checkCodeServlet"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="登入"></td>
			</tr>

		</table>

	</form>
	
	<div><%=request.getAttribute("cc_error") %></div>
	<div><%=request.getAttribute("login_error") %></div>

</body>
</html>

<script>
	window.onload = function({
		document.getElementById("img").onclick = function(){
			this.src = "checkCodeServlet?time="+new Date().getTime();
		}
	})
</script>