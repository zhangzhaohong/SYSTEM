package com.project.pro.servlet;

import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.LyTable;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/mainServ"})
public class mainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int pageSize = 5;
        int totalRec = 0;
        int pageCount = 0;
        int pageNum = 1;

        ArrayList<LyTable> lyList = new ArrayList<LyTable>();

        try {
            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
            String sql = "select COUNT(*) from lyTable";
            ResultSet rs=SqlSrvDB.executeQuery(sql);	//取得结果集

            while(rs.next())
            {
                totalRec = rs.getInt(1);
            }

            pageCount = (totalRec % pageSize ==0)? (totalRec/pageSize):(totalRec/pageSize+1);

            String pageStr = req.getParameter("page");

            pageNum = (pageStr==null)?1:Integer.parseInt(pageStr);
            if(pageNum == 0){
                pageNum = 1;
            }

            int tempGet = 0;
            if(pageNum<pageCount){
                tempGet = pageSize;
            }else{
                tempGet = (totalRec % pageSize==0)?pageSize:(totalRec % pageSize);
            }

            //查询lyTable表中的记录
            // sql = "select * from lyTable";
            sql = "select * from (select top "+tempGet+" * from(select top "+pageNum*pageSize+" * from lyTable order by id)a order by id desc)b order by id";

            rs=SqlSrvDB.executeQuery(sql);	//取得结果集

            // int tempint = 1;


            while(rs.next())
            {
//				if(tempint<(pageNum-1)*pageSize+1){
//					tempint++;
//					continue;
//				}
//				if(tempint>pageNum*pageSize){
//					break;
//				}
                int userid = rs.getInt("userid");

                String username = "";
                sql = "select username from userTable where id="+userid;
                ResultSet userRs = SqlSrvDB.executeQuery(sql);
                while(userRs.next()){
                    username=userRs.getString(1);
                }

                Date lydate = rs.getDate("lydate");
                String title = rs.getString("title");
                String content = rs.getString("lyContent");

                LyTable ly = new LyTable();
                ly.setLydate(lydate);
                ly.setTitle(title);
                ly.setLyContent(content);
                ly.setUsername(username);

                lyList.add(ly);
                //tempint++;

            }
            rs.close();
            SqlSrvDB.closeStmt();					//关闭语句
            SqlSrvDB.closeConn();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        req.setAttribute("myLyList", lyList);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("pageNum", pageNum);


        RequestDispatcher rd =req.getRequestDispatcher("/main.jsp");
        rd.forward(req, resp);
    }

}
