<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
	<title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3"><!--zhangzhaohong 2018128338-->
<% session.removeAttribute("user"); %>
<form name="login" action="loginController" method="post">
<table>
	<caption>用户登录</caption>
	<tr>
		<td>用户名：</td>
		<td>
			<input type="text" name="username" size="20"/>
		</td>
	</tr>
	<tr>
		<td>密码:</td>
		<td>
			<input type="password" name="userpwd" size="21"/>
		</td>
	</tr>
	<tr>
		<td>用户类型：</td>
		<td>
			<input type="radio" name="type" value="admin"/>管理员
			<input type="radio" name="type" value="vip"/>vip用户
			<input type="radio" name="type" value="guest"/>游客
		</td>
	</tr>
</table>
<input type="submit" value="登录"/>
<input type="reset" value="重置"/>
</form>
</body>
</html>
