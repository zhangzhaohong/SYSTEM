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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2018128338张兆泓
 */
@WebServlet(name = "Validate", urlPatterns = {"/ValidateServ"})
public class Validate extends HttpServlet {
    private static final long serialVersionUID = -3737143634491339713L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);
        request.setCharacterEncoding("gb2312");            //设置请求编码
        String usr = request.getParameter("username");            //获取提交的用户名
        String pwd = request.getParameter("password");        //获取提交的密码
        boolean validated = false;                        //验证成功标识
        UserTable user = null;
        HttpSession session = request.getSession();
        user = (UserTable) session.getAttribute("user");
        if (user == null) {
            //查询userTable表中的记录
            String sql = "select * from userTable";
            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
            Connection conn = SqlSrvDB.getConn();
            ResultSet rs = SqlSrvDB.executeQuery(sql);    //取得结果集
            while (true) {
                try {
                    if (!rs.next()) break;
                    if ((rs.getString("username").trim().compareTo(usr) == 0) && (rs.getString("password").compareTo(pwd) == 0) && (rs.getString("userType") != "guest")) {
                        user = new UserTable();
                        user.setId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString(3));
                        user.setUserType(rs.getString(4));
                        session.setAttribute("user", user);
                        validated = true;                        //标识为true表示验证成功通过
                    }
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            SqlSrvDB.closeStmt();                    //关闭语句
            SqlSrvDB.closeConn();                    //关闭连接
        } else {
            validated = true;
        }
        if (validated) {
            response.sendRedirect("main.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

}
