package com.project.pro.dao;

import com.project.pro.vo.Test;

public interface IUserTableDAO {
	
	public Test validatTest(String username, String userpwd, String usertype);
	
	public int saveUser(Test user);
	
}
