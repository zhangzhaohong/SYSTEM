package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.LyTable;
import com.project.pro.vo.UserTable;

import java.sql.Date;
import java.util.Map;

/**
 * ZHANGZHAOHONG 2018128338
 * */
public class AddLyAction extends ActionSupport {
    private LyTable ly;

    /**
     * @return
     */
    public String execute() {
        Map session = ActionContext.getContext().getSession();
        UserTable user = (UserTable) session.get("user");
        if (user == null) {
            return "loginerr";
        }
        if (ly == null) {
            return "error";
        }
        String title = ly.getTitle();
        String content = ly.getLyContent();
        int userid = user.getId();
        Date lydate = new Date(System.currentTimeMillis());
        String sql = "insert lyTable (userid,lydate,title,lyContent) values('" + userid + "','" + lydate + "','" + title + "','" + content + "')";
        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
        System.out.println("[SystemLog]" + sql);
//        Connection conn = SqlSrvDB.getConn();
//        PreparedStatement pstmt = null;
        int num = 0;
        num = SqlSrvDB.executeInsert(sql);
        SqlSrvDB.closeStmt();
        SqlSrvDB.closeConn();
//        try {
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, userid);
//            pstmt.setDate(2, lydate);
//            pstmt.setString(3, title);
//            pstmt.setString(4, content);
//            num = pstmt.executeUpdate(sql);
//            pstmt.close();
//            conn.close();
//        } catch (Exception e) {
//            System.out.println("[SystemLog]" + e.toString());
//        }
        if (num > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public LyTable getLy() {
        return ly;
    }

    public void setLy(LyTable ly) {
        this.ly = ly;
    }
}