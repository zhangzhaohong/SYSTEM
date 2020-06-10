<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="gb2312" import="com.project.pro.vo.UserTable,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>留言板信息</title>
</head>
<body>
<c:if test="${sessionScope.user==null}">
    <jsp:forward page="login.jsp"/>
</c:if>
${user.username } : ${user.userType},您好！欢迎登录留言板。
<div>
    <table border="1">
        <caption>所有留言信息</caption>
        <tr>
            <th>留言人姓名</th><th>留言时间</th><th>留言标题</th><th>留言内容</th>
        </tr>
        <c:forEach items="${requestScope.myLyList}" var="ly">
            <tr>
                <td>${ly.username }</td>
                <td>${ly.lydate }</td>
                <td>${ly.title }</td>
                <td>${ly.lyContent }</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" style="text-align: right;">
                <c:if var="jugFir" test="${requestScope.pageNum==1}">首页|上一页|</c:if>
                <c:if test="${!jugFir}"><a href="mainAction.action?page=1">首页</a>|<a href="mainAction.action?page=${requestScope.pageNum-1 }">上一页</a>|</c:if>

                <c:if var="jugLast" test="${requestScope.pageNum==requestScope.pageCount||requestScope.pageCount==0}">下一页|尾页</c:if>
                <c:if test="${!jugLast}">
                    <a href="mainAction.action?page=${requestScope.pageNum+1 }">下一页</a>|<a href="mainAction.action?page=${requestScope.pageCount }">尾页</a></c:if>
            </td>
        </tr>
    </table>
</div>
<form action="liuyan.jsp" method="post">
    <input type="submit" value="留言">
</form>
</body>
</html>
