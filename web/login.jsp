<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>�������԰�</title>
</head>
<body bgcolor="#E3E3E3">
<% session.removeAttribute("user"); %>
<s:form action="loginValidateAction" method="post">
    <table>
        <caption>�û���¼</caption>
        <tr>
            <td>�û�����</td>
            <td>
                <s:textfield name="user.username" size="20"/>
            </td>
        </tr>
        <tr>
            <td>����:</td>
            <td>
                <s:password name="user.password" size="20"/>
            </td>
        </tr>
        <tr>
            <td>�û�����</td>
            <td>
                <s:radio list="#{'admin':'����Ա','vip':'VIP','guest':'�ο�' }" name="user.userType" value="'����Ա'"></s:radio>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <s:submit value="��¼"/>
                <s:reset value="����"/>
            </td>
        </tr>
    </table>
</s:form><br>
���ûע�ᵥ��<a href="reg.jsp">����</a>ע�ᣡ
</body>
</html>