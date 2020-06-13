package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.MajorDao;
import com.project.org.model.Major;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MajorDaoImp extends BaseDAO implements MajorDao {
    public Major getOneZy(Integer majorid) {
        Major result = null;
        Session session = getSession();
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Major where id=?");
            query.setParameter(0, majorid);
            query.setMaxResults(1);
            result = (Major) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
        return result;
    }

    public List getAll() {
        List list = null;
        Session session = getSession();
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            list = session.createQuery("from Major").list();
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
        return list;
    }
}
