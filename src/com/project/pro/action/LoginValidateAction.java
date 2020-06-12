package com.project.pro.action;

import com.project.pro.service.IUserTableService;
import com.project.pro.vo.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * ZHANGZHAOHONG 2018128338
 */
public class LoginValidateAction extends ActionSupport {

    private Test user;
    private IUserTableService userService;
    private String nameErr;
    private String pwdErr;
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

    public String getNameErr() {
        return nameErr;
    }

    public void setNameErr(String nameErr) {
        this.nameErr = nameErr;
    }

    public String getPwdErr() {
        return pwdErr;
    }

    public void setPwdErr(String pwdErr) {
        this.pwdErr = pwdErr;
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

    @Override
    public void validate() {
        if (user.getUsername() == null || user.getUsername().trim().equals("")) {
            nameErr = "数据不能为空";
            this.addFieldError("", "");
        }
        if (user.getUserpwd() == null || user.getUserpwd().trim().equals("")) {
            pwdErr = "数据不能为空";
            this.addFieldError("", "");
        }
    }

    public void setUser(Test user) {
        this.user = user;
    }

    /**
     * @return
     */
    public String execute() {

        String usr = user.getUsername();
        String pwd = user.getUserpwd();
        String urt = user.getUsertype();

        boolean validated = false;

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();

        Test sessionUser = null;

        sessionUser = (Test) session.get("user");

        if (sessionUser == null) {

            //IUserTableDAO userDao = (IUserTableDAO)ac.getBean("userTableDAO");		//new UserTableDAO();

            //sessionUser = userDao.validatTest(user.getUsername(), user.getUserpwd(), user.getUsertype());

            sessionUser = userService.validateUser(usr, pwd, urt);

            if (sessionUser != null) {
                session.put("user", sessionUser);
                validated = true;
            } else {
                validated = false;
            }

        } else {
            validated = true;
        }

        if (validated) {
            return "success";
        } else {
            return "error";
        }
    }

    public String register() {

        if (user == null) {
            return ERROR;
        }

        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //IUserTableDAO userDao = (IUserTableDAO)ac.getBean("userTableDAO");		//new UserTableDAO();

        //int num = userDao.saveUser(user);

        int num = userService.registerUser(user);

        if (num > 0) {
            userpwdag = null;
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public IUserTableService getUserService() {
        return userService;
    }

    public void setUserService(IUserTableService userService) {
        this.userService = userService;
    }
}