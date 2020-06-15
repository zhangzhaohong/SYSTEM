package com.project.pro.controller;

import com.project.pro.service.UserService;
import com.project.pro.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	private UserService userService;

	/**
	 * 2018128338
	 * ZHANGZHAOHONG
	 * */
	@RequestMapping("/loginController")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		request.setCharacterEncoding("gb2312");
        String usr=request.getParameter("username");
        String pwd=request.getParameter("userpwd");
        String type=request.getParameter("type");
        boolean validated=false;
        Test user = null;
        HttpSession session = request.getSession();
        user = (Test)session.getAttribute("user");
        if(user==null){
        	
        	user = userService.checkLogin(usr, pwd, type);
        	
        	if (user!=null) {
        		session.setAttribute("user", user);
                validated=true;
			}
  		}else{
  			validated=true;
  		}
        if(validated){
        	
        	model.addAttribute("user",user);
        	return "main";
        	
        }else{
        	return "error";
        }
		//return mav;
	}

}
