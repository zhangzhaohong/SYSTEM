package com.project.pro.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class LogoutAction extends ActionSupport {

	/**
	 * @return
	 */
	public String execute() {
		
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		
		return SUCCESS;
	}
}