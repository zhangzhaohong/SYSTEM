package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.MajorDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.project.org.model.Major;

import java.util.List;

public class MajorDaoImp extends BaseDAO implements MajorDao {
	public Major getOneZy(Integer majorid){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Major where id=?");
			query.setParameter(0, majorid);
			query.setMaxResults(1);
			return (Major)query.uniqueResult();	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}

	public List getAll(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			List list=session.createQuery("from Major").list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
}
