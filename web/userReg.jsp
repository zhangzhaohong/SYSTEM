<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="SqlSrvDB" scope="page" class="com.project.pro.jdbc.SqlSrvDBConn"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("gb2312");            //设置请求编码
    String usr = request.getParameter("username");            //获取提交的用户名
    String pwd = request.getParameter("password");        //获取提交的密码
    String type = request.getParameter("userType");        //获取提交的密码
    if (usr == null || pwd == null || type == null) {
%>注册失败，点击<a href="reg.jsp">这里</a>重新注册<%
        return;
    }
    //查询userTable表中的记录
    String sql = "INSERT INTO `userTable` (username,password,userType) VALUES ('" + usr + "', '" + pwd + "', '" + type + "');";
    System.out.println("数据库语句" + sql);
    int result = SqlSrvDB.executeInsert(sql);    //取得结果集
    SqlSrvDB.closeStmt();                    //关闭语句
    SqlSrvDB.closeConn();                    //关闭连接
    if (result > 0) {
%>注册成功，点击<a href="login.jsp">这里</a>登录<%
} else {
%>注册失败，点击<a href="reg.jsp">这里</a>重新注册<%
    }
%>
<h3>正在注册！</h3>

</body>
</html>
