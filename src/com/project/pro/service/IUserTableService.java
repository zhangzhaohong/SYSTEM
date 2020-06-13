package com.project.pro.service;

import com.project.pro.vo.Test;

/**
 * 2018128338 zhangzhaohong
 * */
public interface IUserTableService {
	
	public Test validateUser(String username, String userpwd, String usertype);
	public int registerUser(Test user);
	
}
