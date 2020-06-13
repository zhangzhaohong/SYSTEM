package com.project.pro.dao;

import com.project.pro.vo.UserInfo;

public interface IUserInfoDAO {

    UserInfo getOneUserinfo(int uid);

    int saveOrUpdate(UserInfo userinfo, int id);

}
