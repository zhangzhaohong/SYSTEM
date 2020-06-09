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
        request.setCharacterEncoding("gb2312");
        String usr = request.getParameter("username");            //��ȡ�ύ���û���
        String pwd = request.getParameter("password");        //��ȡ�ύ������
        String uType = request.getParameter("userType");
        boolean validated = false;                        //��֤�ɹ���ʶ
        //��ѯuserTable���еļ�¼
        String sql = "insert userTable(username,password,userType) values('" + usr + "','" + pwd + "','" + uType + "')";

        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
        int num = SqlSrvDB.executeInsert(sql);    //ȡ��

        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();

        SqlSrvDB.closeStmt();                    //�ر����
        SqlSrvDB.closeConn();                    //�ر�����
        if (num > 0) {
//         %>
//         	ע��ɹ������<a href="login.jsp">����</a>����¼������е�¼
//         
//         <%
            out.println("ע��ɹ������<a href=\"login.jsp\">����</a>����¼������е�¼");
        } else {
//         %>
//         	ע�᲻�ɹ������<a href="reg.jsp">����</a>����ע��
//         
//         <%
            out.println("ע�᲻�ɹ������<a href=\"reg.jsp\">����</a>����ע��");
        }
    }
    //2018128331���
}
