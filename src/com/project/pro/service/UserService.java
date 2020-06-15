package com.project.pro.service;

import com.project.pro.vo.Test;

public interface UserService {
	public Test checkLogin(String name, String userpwd, String usertype);
	
}
