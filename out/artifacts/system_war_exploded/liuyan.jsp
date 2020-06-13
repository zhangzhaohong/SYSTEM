<%@ page language="java"  pageEncoding="gb2312" import="com.project.pro.vo.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
	<title>留言板</title>
	<link href="./css/oper_area.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="float: left;">
	<s:form action="addLyAction" method="post" theme="simple">
		<table style="width: 100%;border: 0;border-spacing: 0;padding: 0;">
			<tr>
				<td class="title-bar">
					<table style="width: 98%;border-spacing: 0;padding: 0;">
						<tr>
							<td style="width: 26" class="title-bar-title-icon">&nbsp;</td>
							<td style="width: 745" class="title-bar-text">添加留言</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table style="width: 99%;border-spacing: 0;padding: 0;text-align: center;" class="table-frame" id="p1">
			<tr>
				<td style="width: 18%;height: 22" class="table-frame-input-title">留言标题</td>
				<td style="height: 22" class="table-cell-input">
					<s:textfield name="ly.title" cssClass="form-input" size="51"/>
					<s:hidden name="ly.id"/>
				</td>
			</tr>
			<tr>
				<td style="width: 18%;height: 22" class="table-frame-input-title">留言内容</td>
				<td style="height: 22" class="table-cell-input">
					<s:textarea rows="5" cols="50" name="ly.lyContent"/>
				</td>
			</tr>
		</table>
		<table style="width: 99%;border-spacing: 0;padding: 0;text-align: center;border:0;">
			<tr>
				<td class="buttun-bar">
					<s:submit value="提交" cssClass="form-buttun"/>
					<s:reset value="重置" cssClass="form-buttun"/>
				</td>
			</tr>
		</table>
	</s:form>
</div>
<div>
	<br/>
	&nbsp;<s:label name="titleErr" style="color:red;"/>
	&nbsp;<p name="titleErr" style="color:red;"></p>
	<br/>
	<br/>
	&nbsp;<s:label name="lyContentErr" style="color:red;"/>
</div>
</body>
</html>

