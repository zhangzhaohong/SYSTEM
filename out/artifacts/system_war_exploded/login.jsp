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
<div align="center">
    <s:form action="loginValidateAction" method="post" theme="simple">
        <table border="1" cellspacing="1" cellpadding="1" align="center">
            <caption>�û���¼</caption>
            <tr>
                <td width="150" align="right">�û�����</td>
                <td width="250">
                    <s:textfield name="user.username" size="20"/>
                </td>
            </tr>
            <tr>
                <td width="150" align="right">����:</td>
                <td width="220">
                    <s:password name="user.password" size="20"/>
                </td>
            </tr>
            <tr>
                <td width="150" align="right">�û�����</td>
                <td>
                    <s:radio list="#{'admin':'����Ա','vip':'VIP','guest':'�ο�' }" name="user.userType" value="'admin'"></s:radio>
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
</div>
</body>
</html>