package com.project.pro.servlet;

import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.UserTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Addly", urlPatterns = {"/AddlyServ"})
public class Addly extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);
        request.setCharacterEncoding("gb2312");            //�����������
        String title = request.getParameter("title");            //��ȡ�ύ���û���
        String content = request.getParameter("content");        //��ȡ�ύ������

        HttpSession session = request.getSession();
        UserTable user = (UserTable) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
        }
        int userid = user.getId();
        Date lydate = new Date(System.currentTimeMillis());

        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
        String sql = "insert lyTable(userid,lydate,title,lyContent) values(?,?,?,?)";

        Connection conn = SqlSrvDB.getConn();
        PreparedStatement pstmt = null;
        int num = 0;
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userid);
            pstmt.setDate(2, lydate);
            pstmt.setString(3, title);
            pstmt.setString(4, content);

            num = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {

        }

        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        if (num > 0) {
            out.println("���Գɹ������<a href=\"mainServ\">����</a>�ص���ҳ�档");
        } else {
            out.println("���Բ��ɹ������<a href=\"liuyan.jsp\">����</a>�ص���ҳ�档");
        }

    }

}
