<%@ taglib prefix="c" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板信息</title>
</head>
<body>
<%--
<c:if test="${sessionScope.user==null}">
    <jsp:forward page="login.jsp"/>
</c:if>
${user.username } : ${user.userType},您好！欢迎登录留言板。
<%
    String usr = (String)session.getAttribute("usr");
    if (usr == null){
        response.sendRedirect("login.jsp");
    } else {
        out.print(request.getParameter("username") + "，您好！欢迎登陆留言板。");
    }
%>
--%>
<div align="center">
    <table border="1">
        <caption>所有留言信息</caption>
        <tr>
            <th>留言人姓名</th><th>留言时间</th><th>留言标题</th><th>留言内容</th>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</div>
<h3>登录成功！</h3>

</body>
</html>
