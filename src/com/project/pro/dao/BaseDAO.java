package com.project.pro.dao;

import com.project.LogUtil;
import com.project.pro.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDAO {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e){
            Configuration configure = new Configuration().configure();
            sessionFactory  = configure.buildSessionFactory();
            setSessionFactory(sessionFactory);
            session = sessionFactory.openSession();
        }
        return session;
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
