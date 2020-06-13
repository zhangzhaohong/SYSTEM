package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class LogoutAction extends ActionSupport {

	/**
	 * @return
	 */
	public String execute() {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("action", "退出登录");
		request.setAttribute("oper_info", "退出成功");
		request.setAttribute("next_info", "登录页面");
		request.setAttribute("next_url", "login.jsp");
		return SUCCESS;
	}
}