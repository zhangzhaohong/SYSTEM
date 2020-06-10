package com.project.pro.servlet;

import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.UserTable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="Validate",urlPatterns={"/ValidateServ"})
public class Validate extends HttpServlet {

    private static final long serialVersionUID = -3737143634491339713L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // TODO Auto-generated method stub
        //super.doPost(req, resp);

        request.setCharacterEncoding("gb2312");			//设置请求编码
        String usr=request.getParameter("username");			//获取提交的用户名
        String pwd=request.getParameter("password");		//获取提交的密码
        String uType =request.getParameter("userType");
        boolean validated=false;

        UserTable user = null;
        HttpSession session = request.getSession();

        user = (UserTable)session.getAttribute("user");//验证成功标识

        if(user==null){
            //查询userTable表中的记录
            String sql="select id,username,password,userType from userTable";
            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
            Connection conn = SqlSrvDB.getConn();
            PreparedStatement pstmt = null;

            ResultSet rs=SqlSrvDB.executeQuery(sql);	//取得结果集

            try{
                pstmt = conn.prepareStatement(sql);


                while(rs.next())
                {
                    if((rs.getString("username").trim().compareTo(usr)==0)
                            &&(rs.getString("password").compareTo(pwd)==0)
                            &&(rs.getString("userType").compareTo(uType)==0))
                    {

                        user = new UserTable();
                        user.setId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString(3));
                        user.setUserType(rs.getString(4));


                        session.setAttribute("user", user);

                        validated=true;
                        break;					//标识为true表示验证成功通过
                    }
                }
                rs.close();
            }catch(SQLException e){

            }
            SqlSrvDB.closeStmt();					//关闭语句
            SqlSrvDB.closeConn();					//关闭连接
        }else{
            validated = true;
        }


        if(validated)
        {
            //验证成功跳转到main.jsp
            response.sendRedirect("mainServ");
        }
        else
        {
            //验证失败跳转到error.jsp
            response.sendRedirect("error.jsp");
        }
    }

}
