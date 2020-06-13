package com.project.org.service;

import com.project.org.model.SignIn;

public interface SignInService {
    SignIn find(String sno, String stupwd);
}
