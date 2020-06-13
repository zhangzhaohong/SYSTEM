package com.project.pro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
	
	private SessionFactory sessionFactory;

	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}				

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		session = sessionFactory.openSession();
		return session;
	}
	
	public void closeSession() {
		sessionFactory.close();
	}
	
}
