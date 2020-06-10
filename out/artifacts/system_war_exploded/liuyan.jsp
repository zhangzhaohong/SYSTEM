<%@ page language="java"  pageEncoding="gb2312" import="com.project.pro.vo.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
	<title>留言板</title>
</head>
<body>
	<c:if test="${sessionScope.user==null}">
		<jsp:forward page="login.jsp"/>
	</c:if>
	<s:form action="addLyAction" method="post" theme="simple" >
		<table>
			<caption>填写留言信息`</caption>
			<tr>
				<td>留言标题</td>
				<td><s:textfield name="ly.title"/></td>
			</tr>
			<tr>
				<td>留言内容</td>
				<td><s:textarea name="ly.lyContent" id="content" cols="35" rows="5"/></td>
			</tr>
		</table>
		<s:submit value="提交"/>
		<s:reset value="重置"/>		
	</s:form>
</body>
</html>

