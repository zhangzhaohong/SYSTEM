package com.project.pro.service;

import com.project.pro.vo.Test;

public interface IUserTableService {
	
	public Test validateUser(String username, String userpwd, String usertype);
	public int registerUser(Test user);
	
}
