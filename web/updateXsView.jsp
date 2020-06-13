<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body style="background-color: rgb(239,246,254);">
	<s:set var="xs" value="#request.xsInfo"></s:set>
	<s:form action="updateXs" method="post" enctype="multipart/form-data">
		<table border="0" cellspacing="1" cellpadding="8" width="500">
			<tr>
				<td width="80">学号：</td>
				<td>
					<input type="text" name="student.sno" value="<s:property value="#student.sno"/>" readonly/>
				</td>
			</tr>
			<tr>
				<td width="80">姓名：</td>
				<td>
					<input type="text" name="student.sname"	value="<s:property value="#student.sname"/>"/>
				</td>
			</tr>
			<tr>
				<td width="80">
					<s:radio list="#{1:'男',0:'女'}" value="#student.sex"	label="性别" name="student.sex"></s:radio>
				</td>
			</tr>
			<tr>
				<td width="80">专业：</td>
				<td>
					<select name="student.major.id">
						<s:iterator value="#request.major" id="major">
							<option value="<s:property value="#major.id"/>">
								<s:property value="#major.majorName"/>
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td width="80">出生时间：</td>
				<td>
					<input type="text" name="student.birthday" value="<s:property value="#student.birthday"/>"/>
				</td>
			</tr>
			<tr>
				<td width="80">总学分：</td>
				<td>
					<input type="text" name="student.totalCredits" value="<s:property value="#student.totalCredits"/>"/>
				</td>
			</tr>
			<tr>
				<td width="80">备注：</td>
				<td>
					<input type="text" name="student.remarks" value="<s:property value="#student.remarks"/>"/>
				</td>
			</tr>
			<tr>
				<td>照片</td>
				<td>
					<input type="file" name="photoFile"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="修改"/>
		<!-- 返回上一界面 -->
		<input type="button" value="返回" onclick="javascript:history.back();"/>
	</s:form>
	<!-- 这里用 JavaScript 来实现根据该学生的专业 ID 来显示专业名 -->
	<script type="text/javascript">
		document.getElementById("student.major.id").value= '<s:property value="#student.major.id"/>'
	</script>
</body>
</html>
