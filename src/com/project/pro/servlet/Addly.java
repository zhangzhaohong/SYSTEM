package com.project.pro.servlet;

import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.UserTable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="Addly",urlPatterns={"/AddlyServ"})
public class Addly extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);
        request.setCharacterEncoding("gb2312");			//设置请求编码
        String title=request.getParameter("title");			//获取提交的用户名
        String content=request.getParameter("content");		//获取提交的密码

        HttpSession session = request.getSession();
        UserTable user = (UserTable)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.jsp");
        }
        int userid = user.getId();
        Date lydate = new Date(System.currentTimeMillis());

        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
        String sql = "insert lyTable(userid,lydate,title,lyContent) values(?,?,?,?)";

        Connection conn = SqlSrvDB.getConn();
        PreparedStatement pstmt = null;
        int num=0;
        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,userid);
            pstmt.setDate(2,lydate);
            pstmt.setString(3,title);
            pstmt.setString(4,content);

            num = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        }catch(SQLException e){

        }

        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        if(num>0){
            out.println("留言成功，点击<a href=\"mainServ\">这里</a>回到主页面。");
        }else {
            out.println("留言不成功，点击<a href=\"liuyan.jsp\">这里</a>回到主页面。");
        }

    }

}
