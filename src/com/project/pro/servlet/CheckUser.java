package com.project.pro.servlet;

import com.project.pro.dao.IUserTableDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "checkUser", urlPatterns = {"/CheckUser"})
public class CheckUser extends HttpServlet {

    ApplicationContext ac;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //取得用户填写的学号
        String username = request.getParameter("username");
        //设置响应内容
        String responseContext = "true";
        ac = ContextLoader.getCurrentWebApplicationContext();
        if (ac == null) ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserTableDAO userDao = (IUserTableDAO) ac.getBean("userTableDAO");
        boolean isExist = userDao.isExistUser(username);
        if (isExist) {
            responseContext = "false";
        }
        //将处理结果返回给客户端
        out.println(responseContext);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
