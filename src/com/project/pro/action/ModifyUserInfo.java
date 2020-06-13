package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.project.pro.dao.IUserInfoDAO;
import com.project.pro.vo.Test;
import com.project.pro.vo.UserInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletRequest;

public class ModifyUserInfo extends ActionSupport {

    ApplicationContext ac;
    private UserInfo userinfo;
    public UserInfo getUserinfo() {
        return userinfo;
    }
    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    /**
     * @return
     */
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String uid = request.getParameter("UID");
        ac = ContextLoader.getCurrentWebApplicationContext();
        if (ac == null) ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserInfoDAO userInfoDao = (IUserInfoDAO) ac.getBean("userInfoDAO");    //new UserInfoDAO();

        String method = request.getMethod();
        if (method.equalsIgnoreCase("get")) {
            try {
                userinfo = userInfoDao.getOneUserinfo(Integer.parseInt(uid));
                if (userinfo == null) {
                    userinfo = new UserInfo();
                }
                Test sessionUser = (Test) ActionContext.getContext().getSession().get("user");
                userinfo.setTest(sessionUser);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return SUCCESS;
        } else {

            UserInfo info = new UserInfo();
            int id = 0;
            if (userinfo.getId() != null) {
                id = userinfo.getId();
                info.setId(userinfo.getId());
            }

            //info.setId(userinfo.getId());
            info.setCode(userinfo.getCode().trim());
            info.setCnname(userinfo.getCnname().trim());
            info.setSex(userinfo.getSex().trim());
            info.setBirDate(userinfo.getBirDate().trim());
            info.setSpec(userinfo.getSpec().trim());
            info.setRemarks(userinfo.getRemarks().trim());
            info.setTest(userinfo.getTest());

            int num = userInfoDao.saveOrUpdate(info, id);

            if (num > 0) {
                return "main";

            } else {
                return SUCCESS;
            }
        }
    }
}