<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="background-color: rgb(239,246,254);">
	<h3>请填写学生信息</h3>
	<hr width="700" align="left">
	<s:form action="addstudent" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="0" cellpadding="1">
			<tr>
				<td>
					<s:textfield name="student.sno" label="学号" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="student.sname" label="姓名" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:radio name="student.sex" value="1" list="#{1:'男',0:'女'}" label="性别"/>
				</td>
			</tr>
			<tr>
				<s:select name="student.major.id" list="list" listKey="id" listValue="majorName" headerKey="0" headerValue="--请选择专业--" label="专业"></s:select>
			</tr>
			<tr>
				<s:textfield name="student.birthday" label="出生时间" value=""></s:textfield>
			</tr>
			<tr>
				<td>
					<s:textfield name="student.totalCredits" label="总学分" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield name="student.remarks" label="备注" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td>
					<s:file name="photoFile" label="照片" value=""></s:file>
				</td>
			</tr>
		</table>
		<p>
		<input type="submit" value="添加"/>
		<input type="reset" value="重置"/>
	</s:form>
</body>
</html>
