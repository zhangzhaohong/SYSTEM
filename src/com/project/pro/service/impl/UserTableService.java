package com.project.pro.service.impl;

import com.project.pro.dao.IUserTableDAO;
import com.project.pro.service.IUserTableService;
import com.project.pro.vo.Test;

public class UserTableService implements IUserTableService {
	
	private IUserTableDAO userDAO;
	
	@Override
	public Test validateUser(String username, String userpwd, String usertype) {
		return this.userDAO.validatTest(username, userpwd, usertype);
	}
	
	@Override
	public int registerUser(Test user) {		
		return this.userDAO.saveUser(user);
		
	}

	public IUserTableDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserTableDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
