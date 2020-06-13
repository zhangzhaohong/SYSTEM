package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.ClassesDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.project.org.model.Classes;

import java.util.List;

public class ClassesDaoImp extends BaseDAO implements ClassesDao{
	public List findAll(int pageNow, int pageSize){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Classes");
		int firstResult=(pageNow-1)*pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List list=query.list();
		ts.commit();
		session.close();
		session=null;
		return list;
	}
	public int findClassesSize(){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return session.createQuery("from Classes").list().size();
	}
	public Classes find(String cno){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Classes where cno=?");
			query.setParameter(0, cno);
			query.setMaxResults(1);
			Classes cla=(Classes)query.uniqueResult();
			ts.commit();
			session.clear();
			return cla;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
