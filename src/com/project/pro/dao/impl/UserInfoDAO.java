package com.project.pro.dao.impl;

import com.project.pro.dao.BaseDAO;
import com.project.pro.dao.IUserInfoDAO;
import com.project.pro.vo.Test;
import com.project.pro.vo.UserInfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * 2018128338 张兆泓
 * */
public class UserInfoDAO extends BaseDAO implements IUserInfoDAO {

	@Override
	public UserInfo getOneUserinfo(int uid) {
		UserInfo result = null;
		Session session = getSession();
		session.clear();
		String hql = "from Test where id="+uid;
		Query qu = session.createQuery(hql);
		qu.setMaxResults(1);
		if (qu.list().size()>0) {
			Test test = (Test)qu.uniqueResult();
			result = test.getUserinfo();
		}
		closeSession(session);
		return result;
	}

	@Override
	public int saveOrUpdate(UserInfo userinfo, int id) {
		Session session = getSession();
		session.clear();
		Transaction ts = session.beginTransaction();
		int num = 0;
		
		if (id<1) {
			num = (Integer) session.save(userinfo);
			ts.commit();
		}else {
			
			try {
				session.update(userinfo);
				ts.commit();
				num = 1;
			} catch (HibernateException e) {
				num = 0;
			}
		}
		closeSession(session);
		return num;
	}
}
