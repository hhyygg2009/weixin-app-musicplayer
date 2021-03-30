<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H2>
			用户登录
		</H2>
		<form method="post" action="DoLogin">
			用&nbsp;户&nbsp;名：
			<input type="text" name="name">
			<P>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：
				<input type="password" name="password">
			<P>
			
			<P>
				<input type="submit" value="登录">
				&nbsp;&nbsp;
				<input type="reset" value="重置">
				&nbsp;&nbsp;
				<a href="register.jsp">注册</a>
			<P>
		</form>
</body>
</html>