<%@ page language="java" pageEncoding="gb2312"%>
<html>
<head>
	<title>�������԰�</title>
</head>
<body bgcolor="#E3E3E3"><!--zhangzhaohong 2018128338-->
<% session.removeAttribute("user"); %>
<form name="login" action="loginController" method="post">
<table>
	<caption>�û���¼</caption>
	<tr>
		<td>�û�����</td>
		<td>
			<input type="text" name="username" size="20"/>
		</td>
	</tr>
	<tr>
		<td>����:</td>
		<td>
			<input type="password" name="userpwd" size="21"/>
		</td>
	</tr>
	<tr>
		<td>�û����ͣ�</td>
		<td>
			<input type="radio" name="type" value="admin"/>����Ա
			<input type="radio" name="type" value="vip"/>vip�û�
			<input type="radio" name="type" value="guest"/>�ο�
		</td>
	</tr>
</table>
<input type="submit" value="��¼"/>
<input type="reset" value="����"/>
</form>
</body>
</html>
