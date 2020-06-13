package com.project.pro.service;

import com.project.pro.vo.Test;

/**
 * 2018128338 zhangzhaohong
 */
public interface IUserTableService {

    Test validateUser(String username, String userpwd, String usertype);

    int registerUser(Test user);

}
