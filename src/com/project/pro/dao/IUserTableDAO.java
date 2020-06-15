package com.project.pro.dao;

import com.project.pro.vo.Test;

public interface IUserTableDAO {

    Test validatTest(String username, String userpwd, String usertype);

    int saveUser(Test user);

    boolean isExistUser(String username);

    Test checkLogin(String username, String userpwd, String usertype);
}
