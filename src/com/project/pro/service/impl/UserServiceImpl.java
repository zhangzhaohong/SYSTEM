package com.project.pro.service.impl;

import com.project.pro.dao.IUserTableDAO;
import com.project.pro.service.UserService;
import com.project.pro.vo.Test;
import com.project.pro.vo.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2018128338
 * ZHANGZHOAHONG
 * */
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserTableDAO userdao;

	@Override
	public Test checkLogin(String name, String userpwd, String usertype) {
		return userdao.checkLogin(name,userpwd,usertype);
	}
	
}
