package com.project.org.dao;

import com.project.LogUtil;
import com.project.pro.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 2018128338 张兆泓
 * */
public class BaseDAO {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession() {
        sessionFactory.close();
    }

    public void closeSession(Session session) {
        try {
            HibernateSessionFactory.closeSession();
            session.flush();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            new LogUtil().printLn(e.toString());
        }
    }
}
