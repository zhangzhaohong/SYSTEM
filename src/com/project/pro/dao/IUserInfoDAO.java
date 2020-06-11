package com.project.pro.dao;

import com.project.pro.vo.UserInfo;

public interface IUserInfoDAO {
	
	public UserInfo getOneUserinfo(int uid);
	
	public int saveOrUpdate(UserInfo userinfo, int id);
	
}
