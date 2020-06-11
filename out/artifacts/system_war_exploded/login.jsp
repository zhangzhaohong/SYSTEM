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
    <title>简易留言板</title>
    <style type="text/css">
        body{
            background-image: url(./images/oper_area_border_top_line.gif);
            background-color: #EFF6FE;
            margin: 0;
        }
        table,tr,td{
            border: 0px solid black;
            border-spacing: 0;
            padding: 0;
            margin: 0 auto;
        }
        table{
            border-collapse: collapse;
        }
        .login_tab{
            margin-right:-20px;
            width:300px;
        }
        .login_tab table{
            width:100%;
            height:205px;

        }
        .login_tab th,td{
            text-align:center;
            font-size: 12px;
        }
        .login_tab th{
            text-align:right;
        }
        .form_input{
            font-size: 12px;
            color: #000000;
            background-color: #FFFFFF;
            border: 1px solid #003366;
        }
        .reg_tab{
            height:400px
        }
        .reg_tab table{
            height:370px;
            width:100%;
        }

    </style>
</head>
<body bgcolor="#E3E3E3">
<% session.removeAttribute("user"); %>
<div align="center" style="margin: 50px">
    <s:i18n name="messageResource">
        <s:form action="loginValidateAction" method="post" theme="simple">
            <table border="1" cellspacing="1" cellpadding="1" align="center">
                <caption>用户登录</caption>
                <tr>
                    <td width="150" align="right">用户名：</td>
                    <td width="250">
                        <s:textfield name="user.username" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td width="150" align="right">密码:</td>
                    <td width="220">
                        <s:password name="user.password" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td width="150" align="right">用户级别：</td>
                    <td>
                        <s:radio list="#{'admin':'管理员','vip':'VIP','guest':'游客' }" name="user.userType" value="'admin'"></s:radio>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <s:submit value="登录"/>
                        <s:reset value="重置"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><img src="images/login/lo.gif" /></td>
                </tr>
            </table>
        </s:form>
    </s:i18n>
    <br>如果没注册单击<a href="reg.jsp">这里</a>注册！
</div>
</body>
</html>