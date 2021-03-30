<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新用户注册</title>
<script type="text/javascript">		
		function validate(){
			if(document.forms.registerForm.name.value==""){
				alert("用户名为空");
				return;
			}
			if(document.forms.registerForm.password.value==""){
				alert("密码为空");
				return;
			}
			if(document.forms.registerForm.password.value!=document.forms.registerForm.rpassword.value){
				alert("密码，确认密码不一致");
				return;
			}
			
			if(document.forms.registerForm.age.value==""){
				alert("年龄为空");
				return;
			}
			if(document.forms.registerForm.gender.value==""){
				alert("性别为空");
				return;
			}
			if(document.forms.registerForm.email.value==""){
				alert("email为空");
				return;
			}
			if(document.forms.registerForm.education.value==""){
				alert("学历为空");
				return;
			}
			if(document.forms.registerForm.interesting.value==""){
				alert("兴趣为空");
				return;
			}
			
			document.forms.registerForm.submit();
			
		}
		
		
		</script>
</head>
<body>
		<H2>用户注册</H2>
		<form name="registerForm" method="post" action="DoRegister">
			用&nbsp;户&nbsp;名：
			<input type="text" name="name">
			<P>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：
				<input type="password" name="password">
			<P>
				密码确认：
				<input type="password" name="rpassword">
			<P>
				年&nbsp;&nbsp;&nbsp;&nbsp;龄：
				<input type="text" name="age">
			<P>
				性&nbsp;&nbsp;&nbsp;&nbsp;别：
				<input type="radio" name="gender" value="男" checked>
				男
				<input type="radio" name="gender" value="女">
				女
			<P>
				电子邮件：
				<input type="text" name="email">
			<P>
				学&nbsp;&nbsp;&nbsp;&nbsp;历：
				<select name="education">
					<option>大专</option>
					<option>本科</option>
					<option>硕士</option>
				</select>
			<P>
				兴&nbsp;&nbsp;&nbsp;&nbsp;趣：
				<select name="interesting" multiple>
					<option value="ball">打球</option>
					<option value="swimming">游泳</option>
					<option value="running">跑步</option>
				</select>
			<P>
				<input type="button" value="注册" onClick="validate()">
				&nbsp;&nbsp;
				<input type="reset" value="重置">
			<P>
		</form>
</body>
</html>