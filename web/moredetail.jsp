<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head></head>
<body style="background-color: rgb(239,246,254);">
<h3>该学生信息如下：</h3>
<s:set var="student" value="#request.student"></s:set>
<s:form action="studentInfo" method="post">
    <table border="0" cellpadding="5">
        <tr>
            <td>学号：</td>
            <td width="100">
                <s:property value="#student.sno"/>
            </td>
            <td rowspan="7">
                <%--<img src="getImage.action?xs.xh=<s:property value="#student.photo"/>" width="120" height="150">--%>
                <img src="./images/user-default.jpg" width="120" height="150">
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td width="100">
                <s:property value="#student.sname"/>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td width="100">
                <s:if test="#student.sex==1">男</s:if>
                <s:else>女</s:else>
            </td>
        </tr>
        <tr>
            <td>专业：</td>
            <td width="100">
                <s:property value="#student.major.majorName"/>
            </td>
        </tr>
        <tr>
            <td>出生时间：</td>
            <td width="100">
                <s:property value="#student.birthday"/>
            </td>
        </tr>
        <tr>
            <td>总学分</td>
            <td width="100">
                <s:property value="#student.totalCredits"/>
            </td>
        </tr>
        <tr>
            <td>备注</td>
            <td width="100">
                <s:property value="#student.remarks"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                <s:submit value="返回"/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
