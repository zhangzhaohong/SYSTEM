package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.LyTable;
import com.project.pro.vo.UserTable;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

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