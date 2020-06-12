package com.project.org.service.imp;

import com.project.org.dao.SignInDao;
import com.project.org.model.SignIn;
import com.project.org.service.SignInService;

public class SignInServiceManage implements SignInService {
	private SignInDao signInDao;
	public SignIn find(String sno, String stupwd){
		return signInDao.find(sno, stupwd);
	}
	public SignInDao getSignInDao() {
		return signInDao;
	}
	public void setSignInDao(SignInDao signInDao) {
		this.signInDao = signInDao;
	}
	
}
