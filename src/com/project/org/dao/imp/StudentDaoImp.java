package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.StudentDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.project.org.model.Student;

import java.util.List;

public class StudentDaoImp extends BaseDAO implements StudentDao{
	public List findAll(int pageNow, int pageSize){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Student order by sno");
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			session.close();
			session=null;
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public int findstudentSize(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			return session.createQuery("from Student").list().size();			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	public Student find(String sno){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Student where sno=?");
			query.setParameter(0, sno);
			query.setMaxResults(1);
			Student student=(Student)query.uniqueResult();
			ts.commit();
			session.clear();
			return student;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}

	public void delete(String sno){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Student student=find(sno);
			session.delete(student);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void update(Student student){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.update(student);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void save(Student student){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.save(student);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
