package com.project.pro.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.LyTable;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LyMainAction extends ActionSupport {

    /**
     * @return
     */
    public String execute() {


        int pageSize = 5;
        int totalRec = 0;
        int pageCount = 0;
        int pageNum = 1;


        ArrayList<LyTable> lyList = new ArrayList<LyTable>();

        HttpServletRequest req = ServletActionContext.getRequest();

        try {
            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
            String sql = "select COUNT(*) from lyTable";
            ResultSet rs = SqlSrvDB.executeQuery(sql);    //ȡ�ý����

            while (rs.next()) {
                totalRec = rs.getInt(1);
            }

            pageCount = (totalRec % pageSize == 0) ? (totalRec / pageSize) : (totalRec / pageSize + 1);

            String pageStr = req.getParameter("page");

            pageNum = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
            if (pageNum == 0) {
                pageNum = 1;
            }

            int tempGet = 0;
            if (pageNum < pageCount) {
                tempGet = pageSize;
            } else {
                tempGet = (totalRec % pageSize == 0) ? pageSize : (totalRec % pageSize);
            }

            //��ѯlyTable���еļ�¼
            // sql = "select * from lyTable";
            sql = "select * from (select top " + tempGet + " * from(select top " + pageNum * pageSize + " * from lyTable order by id)a order by id desc)b order by id";

            rs = SqlSrvDB.executeQuery(sql);    //ȡ�ý����

            // int tempint = 1;


            while (rs.next()) {
//				if(tempint<(pageNum-1)*pageSize+1){
//					tempint++;
//					continue;
//				}
//				if(tempint>pageNum*pageSize){
//					break;
//				}
                int userid = rs.getInt("userid");

                String username = "";
                sql = "select username from userTable where id=" + userid;
                ResultSet userRs = SqlSrvDB.executeQuery(sql);
                while (userRs.next()) {
                    username = userRs.getString(1);
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
            SqlSrvDB.closeStmt();
            SqlSrvDB.closeConn();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        req.setAttribute("myLyList", lyList);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("pageNum", pageNum);


        //RequestDispatcher rd =req.getRequestDispatcher("/main.jsp");
        //rd.forward(req, resp);


        return SUCCESS;
    }
}