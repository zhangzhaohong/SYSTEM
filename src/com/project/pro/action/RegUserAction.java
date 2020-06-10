package com.project.pro.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.UserTable;


public class RegUserAction extends ActionSupport {

    private UserTable user;

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }

    /**
     * @return
     */
    public String execute() {
        if (user == null) {
            return ERROR;
        }
        String usr = user.getUsername();
        String pwd = user.getPassword();
        String urt = user.getUserType();
        String sql = "insert userTable (username,password,userType) values('" + usr + "','" + pwd + "','" + urt + "')";
        SqlSrvDBConn SqlSrvDB = new SqlSrvDBConn();
        int num = SqlSrvDB.executeInsert(sql);
        SqlSrvDB.closeStmt();
        SqlSrvDB.closeConn();
        if (num > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}