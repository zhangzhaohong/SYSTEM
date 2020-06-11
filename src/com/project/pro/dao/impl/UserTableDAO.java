package com.project.pro.dao.impl;

import com.project.pro.dao.BaseDAO;
import com.project.pro.dao.IUserTableDAO;
import com.project.pro.factory.HibernateSessionFactory;
import com.project.pro.vo.Test;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserTableDAO extends BaseDAO implements IUserTableDAO {

	@Override
	public Test validatTest(String username, String userpwd, String usertype) {
		String hql = "from Test where username=? and userpwd=? and usertype=?";
    	
    	Query qu = getSession().createQuery(hql);		
		qu.setString(0, username);
		qu.setString(1, userpwd);
		qu.setString(2, usertype);
		
		List users = qu.list();
		
		if (users.size()>0) {
			return (Test) users.get(0);
		}
		
		return null;
	}

	@Override
	public int saveUser(Test user) {
		Session session = getSession();
		Transaction ts = session.beginTransaction();
		int sucNum = (Integer)session.save(user);
		
		ts.commit();
		
		HibernateSessionFactory.closeSession();
		
		return sucNum;
	}

}
