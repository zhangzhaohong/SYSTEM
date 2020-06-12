<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020/6/4
  Time: 10:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户注册</title>
    <style type="text/css">
        body{
            background: url(./images/login-bg.jpeg);
        }
    </style>
</head>
<body>
<s:form name="userReg" id="userReg" action="regUserAction" method="post" theme="simple">
    <table border="1" cellspacing="1" cellpadding="1" align="center" height="400" width="500">
        <caption>用户注册</caption>
        <tr>
            <td width="150" align="right">用户名：</td>
            <td width="300">
                <s:textfield id="username" name="user.username" placeholder="请输入用户名" style="width:150"/>&nbsp;
                <s:label name="nameregErr" style="color:red;"/>
            </td>
        </tr>
        <tr>
            <td width="150" align="right">密码：</td>
            <td width="400">
                <s:password id="userpwd" name="user.userpwd" placeholder="请输入密码" style="width:150"/>&nbsp;
                <s:label name="pwdregErr" style="color:red;"/>
            </td>
        </tr>
        <tr>
            <td width="150" align="right">确认密码：</td>
            <td width="220"><input type="password" name="rewritePassword" id="rewritePassword" placeholder="请再次输入密码"/></td>
        </tr>
        <tr>
            <td width="100" align="center">用户类型：</td>
            <td width="400">
                <s:radio list="#{'admin':'管理员','vip':'VIP','guest':'游客'}" name="user.usertype" value="guest"/>&nbsp;
                <s:label name="typeregErr" style="color:red;"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <s:submit value="注册"/>&nbsp;&nbsp;
                <input type="reset" name="" value="重置" />&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
