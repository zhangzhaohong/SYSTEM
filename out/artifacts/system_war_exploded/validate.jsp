<%--
  Created by IntelliJ IDEA.
  User: zhangzhaohong
  Date: 2020-03-14
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="gb2312" import="java.sql.*" %>
<jsp:useBean id="SqlSrvDB" scope="page" class="com.project.pro.jdbc.SqlSrvDBConn"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
</head>
<body>
<%
    request.setCharacterEncoding("gb2312");            //�����������
    String usr = request.getParameter("username");            //��ȡ�ύ���û���
    String pwd = request.getParameter("password");        //��ȡ�ύ������
    boolean validated = false;                        //��֤�ɹ���ʶ
    //��ѯuserTable���еļ�¼
    String sql = "select * from userTable";
    ResultSet rs = SqlSrvDB.executeQuery(sql);    //ȡ�ý����
    while (rs.next()) {
        if ((rs.getString("username").trim().compareTo(usr) == 0) && (rs.getString("password").compareTo(pwd) == 0) && (rs.getString("userType") != "guest")) {
            validated = true;                        //��ʶΪtrue��ʾ��֤�ɹ�ͨ��
        }
    }
    rs.close();
    SqlSrvDB.closeStmt();                    //�ر����
    SqlSrvDB.closeConn();                    //�ر�����
    if (validated) {
        //��֤�ɹ���ת��main.jsp
%>
<jsp:forward page="main.jsp"/>
<%
} else {
    //��֤ʧ����ת��error.jsp
%>
<jsp:forward page="error.jsp"/>
<%
    }
%>
</body>
</html>
