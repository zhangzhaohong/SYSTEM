package com.project.pro.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.Test;
import com.project.pro.vo.UserTable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
** 2018128338 zhangzhaohong
* */
public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("gb2312");
        String usr=request.getParameter("username");
        String pwd=request.getParameter("userpwd");
        String type=request.getParameter("type");
        
        ModelAndView mav = new ModelAndView();
        
        boolean validated=false;
        
        Test user = null;
        HttpSession session = request.getSession();
        
        user = (Test) session.getAttribute("user");
        
        if(user==null){

            String sql="select * from test";
            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
            Connection conn = SqlSrvDB.getConn();
            PreparedStatement pstmt = null;
            ResultSet rs=SqlSrvDB.executeQuery(sql);
            try {
            	pstmt = conn.prepareStatement(sql);
	            while(rs.next())
	            {
	                if((rs.getString("username").trim().compareTo(usr)==0)
								&&(rs.getString("userpwd").compareTo(pwd)==0)
								&&(rs.getString("usertype").compareTo(type)==0))
	                {
	                	user = new Test();
	                	user.setId(rs.getInt("id"));
	                	user.setUsername(rs.getString("username"));
	                	user.setUserpwd(rs.getString(3));
	                	user.setUsertype(rs.getString(4));
	                	
	                	session.setAttribute("user", user);
	                	
	                    validated=true;
	                }
	            }
	          
	            rs.close();
            }catch(SQLException e) {
            	
            }
            SqlSrvDB.closeStmt();
            SqlSrvDB.closeConn();
  		}else{
  			validated=true;
  		}
  		
  		
        if(validated)
        {
            
        	mav.addObject( "username" , usr );
        	mav.setViewName("/frmMain.jsp");
        	
        }
        else
        {
        	mav.setViewName("/error.jsp");
        }
		return mav;
	}

}
