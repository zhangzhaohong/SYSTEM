package com.project.pro.servlet;

import com.project.pro.jdbc.SqlSrvDBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DealReg", urlPatterns = {"/DealRegServ"})
public class DealReg extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);
        request.setCharacterEncoding("gb2312");            //设置请求编码
        String usr = request.getParameter("username");            //获取提交的用户名
        String pwd = request.getParameter("password");        //获取提交的密码
        String uType = request.getParameter("userType");
        boolean validated = false;                        //验证成功标识
        //查询userTable表中的记录
        String sql = "insert userTable(username,password,userType) values('" + usr + "','" + pwd + "','" + uType + "')";

        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
        int num = SqlSrvDB.executeInsert(sql);    //取得

        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();

        SqlSrvDB.closeStmt();                    //关闭语句
        SqlSrvDB.closeConn();                    //关闭连接
        if (num > 0) {
//         %>
//         	注册成功，点击<a href="login.jsp">这里</a>到登录界面进行登录
//         <%
            out.println("注册成功，点击<a href=\"login.jsp\">这里</a>到登录界面进行登录");
        } else {
//         %>
//         	注册不成功，点击<a href="reg.jsp">这里</a>重新注册
//         <%
            out.println("注册不成功，点击<a href=\"reg.jsp\">这里</a>重新注册");
        }
    }
}
