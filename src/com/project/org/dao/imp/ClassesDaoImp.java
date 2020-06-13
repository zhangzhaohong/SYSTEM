package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.ClassesDao;
import com.project.org.model.Classes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClassesDaoImp extends BaseDAO implements ClassesDao {
    public List findAll(int pageNow, int pageSize) {
        Session session = getSession();
        session.clear();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("from Classes");
        int firstResult = (pageNow - 1) * pageSize;
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        List list = query.list();
        ts.commit();
        closeSession(session);
        return list;
    }

    public int findClassesSize() {
        Session session = getSession();
        session.clear();
        Transaction ts = session.beginTransaction();
        int num = session.createQuery("from Classes").list().size();
        closeSession(session);
        return num;
    }

    public Classes find(String cno) {
        Session session = getSession();
        Classes cla = null;
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Classes where cno=?");
            query.setParameter(0, cno);
            query.setMaxResults(1);
            cla = (Classes) query.uniqueResult();
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
        return cla;
    }
}
