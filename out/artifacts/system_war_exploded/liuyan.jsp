<%@ page language="java"  pageEncoding="gb2312" import="com.project.pro.vo.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
	<title>���԰�</title>
</head>
<body>
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp"/>
	</c:if>
	<s:form action="addLyAction" method="post" theme="simple" >
		<table>
			<caption>��д������Ϣ`</caption>
			<tr>
				<td>���Ա���</td>
				<td><s:textfield name="ly.title"/></td>
			</tr>
			<tr>
				<td>��������</td>
				<td><s:textarea name="ly.lyContent" id="content" cols="35" rows="5"/></td>
			</tr>
		</table>
		<s:submit value="�ύ"/>
		<s:reset value="����"/>		
	</s:form>
</body>
</html>

