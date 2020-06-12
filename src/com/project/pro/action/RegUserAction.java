package com.project.pro.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.dao.IUserTableDAO;
import com.project.pro.jdbc.SqlSrvDBConn;
import com.project.pro.vo.Test;
import com.project.pro.vo.UserTable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ZHANGZHAOHONG 2018128338
 * */
public class RegUserAction extends ActionSupport {

    private Test user;
    private String nameregErr;
    private String pwdregErr;
    private String pwdagregErr;
    private String typeregErr;
    private String userpwdag;

    public String getUserpwdag() {
        return userpwdag;
    }

    public void setUserpwdag(String userpwdag) {
        this.userpwdag = userpwdag;
    }

    public String getNameregErr() {
        return nameregErr;
    }

    public void setNameregErr(String nameregErr) {
        this.nameregErr = nameregErr;
    }

    public String getPwdregErr() {
        return pwdregErr;
    }

    public void setPwdregErr(String pwdregErr) {
        this.pwdregErr = pwdregErr;
    }

    public String getPwdagregErr() {
        return pwdagregErr;
    }

    public void setPwdagregErr(String pwdagregErr) {
        this.pwdagregErr = pwdagregErr;
    }

    public String getTyperegErr() {
        return typeregErr;
    }

    public void setTyperegErr(String typeregErr) {
        this.typeregErr = typeregErr;
    }

    public Test getUser() {
        return user;
    }

    public void setUser(Test user) {
        this.user = user;
    }

    @Override
    public void validate() {
        //用户名非空
        String usr = user.getUsername();
        String pwd = user.getUserpwd();
        String urt = user.getUsertype();
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

        if (user==null) {
            return ERROR;
        }

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUserTableDAO userDao = (IUserTableDAO)ac.getBean("userTableDAO");		//new UserTableDAO();

        int num = userDao.saveUser(user);

        if(num>0)
        {
            return SUCCESS;
        }
        else
        {
            return ERROR;
        }
    }
}