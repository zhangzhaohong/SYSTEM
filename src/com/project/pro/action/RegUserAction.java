package com.project.pro.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.UserTable;

/**
 * ZHANGZHAOHONG 2018128338
 * */
public class RegUserAction extends ActionSupport {

    private UserTable user;

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }

    @Override
    public void validate() {
        //用户名非空
        String usr = user.getUsername();
        String pwd = user.getPassword();
        String urt = user.getUserType();
        if (usr==null || "".equals(usr)){
            //保存错误信息
            super.addFieldError("userName","用户名必须填写！");
        }

        //密码
        if (pwd==null || "".equals(pwd)){
            super.addFieldError("pwd","密码必填");
        }

        if (urt==null || "".equals(urt)){
            super.addFieldError("urt","种类不能为空");
        }
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