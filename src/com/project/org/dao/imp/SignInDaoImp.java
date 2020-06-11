package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.SignInDao;
import org.hibernate.Query;
import org.hibernate.Session;
import com.project.org.model.SignIn;

import java.util.Iterator;
import java.util.List;

public class SignInDaoImp extends BaseDAO implements SignInDao{
	public SignIn find(String sno, String stupwd){
		String hql="from SignIn u where u.sno=? and u.stupwd=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, sno);
		query.setParameter(1, stupwd);
		List users=query.list();
		Iterator it=users.iterator();
		while(it.hasNext()){
			if(users.size()!=0){
				SignIn user=(SignIn)it.next();	//�����־û��� JavaBean ���� user
				return user;
			}
		}
		session.close();
		return null;
	}
}
