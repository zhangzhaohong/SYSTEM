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
    <title>���԰���Ϣ</title>
</head>
<body>
<c:if test="${sessionScope.user==null}">
    <jsp:forward page="login.jsp"/>
</c:if>
${user.username } : ${user.userType},���ã���ӭ��¼���԰塣
<div>
    <table border="1">
        <caption>����������Ϣ</caption>
        <tr>
            <th>����������</th><th>����ʱ��</th><th>���Ա���</th><th>��������</th>
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
                <c:if var="jugFir" test="${requestScope.pageNum==1}">��ҳ|��һҳ|</c:if>
                <c:if test="${!jugFir}"><a href="mainAction.action?page=1">��ҳ</a>|<a href="mainAction.action?page=${requestScope.pageNum-1 }">��һҳ</a>|</c:if>

                <c:if var="jugLast" test="${requestScope.pageNum==requestScope.pageCount||requestScope.pageCount==0}">��һҳ|βҳ</c:if>
                <c:if test="${!jugLast}">
                    <a href="mainAction.action?page=${requestScope.pageNum+1 }">��һҳ</a>|<a href="mainAction.action?page=${requestScope.pageCount }">βҳ</a></c:if>
            </td>
        </tr>
    </table>
</div>
<form action="liuyan.jsp" method="post">
    <input type="submit" value="����">
</form>
</body>
</html>
