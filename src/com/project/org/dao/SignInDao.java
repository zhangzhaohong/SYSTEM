package com.project.org.dao;

import com.project.org.model.SignIn;

public interface SignInDao {
    SignIn find(String sno, String stupwd);
}
