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
        if (key == ""){
            alert(title + "不能为空，请输入" + title);
            objElement.focus();
            return true;
        }
        return false;
    }
    function submitCheck() {
        if (isBlankByName("username", '用户名')){
            return false;
        }
        if (isBlankByName("password", '密码')){
            return false;
        }
        var passwordElement = document.getElementById("password");
        var passwordRewriteElement = document.getElementById("rewritePassword");
        var p1 = passwordElement.value;
        var p2 = passwordRewriteElement.value;
        if (p1 != p2){
            alert("两次输入的密码不一致");
            passwordRewriteElement.focus();
            return false;
        }
        return true;
    }
</script>
</body>
<form name="userReg" id="userReg" action="userReg.jsp" method="post">
    <table border="1" cellspacing="1" cellpadding="1" align="center">
        <caption>用户注册</caption>
        <tr>
            <td width="150" align="right">用户名：</td>
            <td width="250">
                <input type="text" name="username" id="username" placeholder="请输入用户名">
            </td>
        </tr>
        <tr>
            <td width="150" align="right">密码：</td>
            <td width="220">
                <input type="password" name="password" id="password" placeholder="请输入密码">
            </td>
        </tr>
        <tr>
            <td width="150" align="right">确认密码：</td>
            <td width="220">
                <input type="password" name="password" id="rewritePassword" placeholder="请再次输入密码">
            </td>
        </tr>
        <tr>
            <td width="150" align="right">用户级别：</td>
            <td width="220">
                <select name="userType">
                    <option value = "guest">guest</option>
                    <option value = "admin">admin</option>
                    <option value = "vip">vip</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="button" name="" onclick="javascript:operater('userReg')" value="注册">&nbsp;&nbsp;
                <input type="button" name="" value="重置">&nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</html>
