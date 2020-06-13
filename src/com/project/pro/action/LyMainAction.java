package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.dao.ILyTableDAO;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.LyTable;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ZHANGZHAOHONG 2018128338
 * */
public class LyMainAction extends ActionSupport {

    ApplicationContext ac;
    /**
     * @return
     */
    public String execute() {

        int pageSize = 5;
        int totalRec = 0;
        int pageCount = 0;
        int pageNum = 1;
        ac = ContextLoader.getCurrentWebApplicationContext();
        if (ac == null) ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<LyTable> lyList = new ArrayList<LyTable>();
        HttpServletRequest request = ServletActionContext.getRequest();

        String pageStr = request.getParameter("page");
        String filter = request.getParameter("filter");
        String order = request.getParameter("order");
        String searchType = request.getParameter("searchType");
        String searchCon = request.getParameter(searchType);

        try {

            ILyTableDAO lyDao = (ILyTableDAO)ac.getBean("lyTableDAO");	//new LyTableDAO();
            totalRec = lyDao.getCountRec(filter,order,searchType,searchCon);

            pageCount = (totalRec%pageSize==0)?(totalRec/pageSize):(totalRec/pageSize+1);

            pageNum = (pageStr==null)?1:Integer.parseInt(pageStr);
            if(pageNum==0) {
                pageNum=1;
            }
            lyList = lyDao.getLyList((pageNum-1)*pageSize, pageSize,filter,order,searchType,searchCon);

        } catch (Exception e) {
            e.printStackTrace();
        }


        Map session = ActionContext.getContext().getSession();

        session.put("myLyList", lyList);
        session.put("pageCount", pageCount);
        session.put("pageNum", pageNum);
        session.put("totalRec", totalRec);

        return SUCCESS;

//        int pageSize = 5;
//        int totalRec = 0;
//        int pageCount = 0;
//        int pageNum = 1;
//
//        ArrayList<LyTable> lyList = new ArrayList<LyTable>();
//        HttpServletRequest req = ServletActionContext.getRequest();
//
//        try {
//            SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
//            String sql = "select COUNT(*) from lyTable";
//            ResultSet rs = SqlSrvDB.executeQuery(sql);
//            while (rs.next()) {
//                totalRec = rs.getInt(1);
//            }
//            pageCount = (totalRec % pageSize == 0) ? (totalRec / pageSize) : (totalRec / pageSize + 1);
//
//            String pageStr = req.getParameter("page");
//
//            pageNum = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
//            if (pageNum == 0) {
//                pageNum = 1;
//            }
//
//            int tempGet = 0;
//            if (pageNum < pageCount) {
//                tempGet = pageSize;
//            } else {
//                tempGet = (totalRec % pageSize == 0) ? pageSize : (totalRec % pageSize);
//            }
//            sql = "select * from lyTable";
//            //SELECT * FROM (errorData) ORDER BY (errorID) DESC LIMIT (:minNum), (:dataNum)
//            sql = "select * from lyTable order by id desc limit " + (pageNum - 1) * pageSize + "," + pageSize;
//            // sql = "select * from (select top "+tempGet+" * from(select top "+pageNum*pageSize+" * from lyTable order by id)a order by id desc)b order by id";
//            rs = SqlSrvDB.executeQuery(sql);
//            // int tempint = 1;
//            while (rs.next()) {
////				if(tempint<(pageNum-1)*pageSize+1){
////					tempint++;
////					continue;
////				}
////				if(tempint>pageNum*pageSize){
////					break;
////				}
//                int userid = rs.getInt("userid");
//
//                String username = "";
//                sql = "select username from test where id=" + userid;
//                ResultSet userRs = SqlSrvDB.executeQuery(sql);
//                while (userRs.next()) {
//                    username = userRs.getString(1);
//                }
//
//                Date lydate = rs.getDate("lydate");
//                String title = rs.getString("title");
//                String content = rs.getString("lyContent");
//
//                LyTable ly = new LyTable();
//                ly.setLydate(lydate);
//                ly.setTitle(title);
//                ly.setLyContent(content);
//                ly.setUsername(username);
//
//                lyList.add(ly);
//                //tempint++;
//
//            }
//            rs.close();
//            SqlSrvDB.closeStmt();
//            SqlSrvDB.closeConn();
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        req.setAttribute("myLyList", lyList);
//        req.setAttribute("pageCount", pageCount);
//        req.setAttribute("pageNum", pageNum);
//        //RequestDispatcher rd =req.getRequestDispatcher("/main.jsp");
//        //rd.forward(req, resp);
//        return SUCCESS;
    }
}