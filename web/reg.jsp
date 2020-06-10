<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020/6/4
  Time: 10:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<script>
    function operater(nextStep) {
        if (submitCheck()) {
            document.userReg.submit()
        }
    }

    function isBlankByName(objName, title) {
        var objElement = document.getElementById(objName);
        key = objElement.getAttribute("value");
        if (key == "") {
            alert(title + "不能为空，请输入" + title);
            objElement.focus();
            return true;
        }
        return false;
    }

    function submitCheck() {
        if (isBlankByName("username", '用户名')) {
            return false;
        }
        if (isBlankByName("password", '密码')) {
            return false;
        }
        var passwordElement = document.getElementById("password");
        var passwordRewriteElement = document.getElementById("rewritePassword");
        var p1 = passwordElement.value;
        var p2 = passwordRewriteElement.value;
        if (p1 != p2) {
            alert("两次输入的密码不一致");
            passwordRewriteElement.focus();
            return false;
        }
        return true;
    }
</script>
</body>
<div align="center">
    <s:form name="userReg" id="userReg" action="regUserAction" method="post" theme="simple">
        <table border="1" style="border-spacing:1px;padding:1px;text-align:center;height:400px;">
            <caption>用户注册</caption>
            <tr>
                <td width="150" align="right">用户名：</td>
                <td width="250">
                    <s:textfield name="user.username" id="username" placeholder="请输入用户名"/>
                </td>
            </tr>
            <tr>
                <td width="150" align="right">密码：</td>
                <td width="220"><s:password name="user.password" id="password" placeholder="请输入密码"/></td>
            </tr>
            <tr>
                <td width="150" align="right">确认密码：</td>
                <td width="220"><input type="password" name="rewritePassword" id="rewritePassword" placeholder="请再次输入密码"/></td>
            </tr>
            <tr>
                <td width="150" align="right">用户级别：</td>
                <td width="220">
                    <s:radio list="#{'admin':'管理员','vip':'VIP','guest':'游客' }" name="user.userType" value="'admin'"></s:radio>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2" style="text-align: center;">
                    <s:submit value="注册"/>
                    <s:reset value="重置"/>
                </td>
            </tr>
        </table>
    </s:form>
</div>
</html>
