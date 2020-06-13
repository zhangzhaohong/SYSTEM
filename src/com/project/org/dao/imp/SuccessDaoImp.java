package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.SuccessDao;
import com.project.org.model.Success;
import com.project.org.model.SuccessId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SuccessDaoImp extends BaseDAO implements SuccessDao {
    public Success getschool(String sno, String cno) {
        SuccessId successId = new SuccessId();
        successId.setSno(sno);
        successId.setCno(cno);
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        return session.get(Success.class, successId);
    }

    public void saveorupdateSuccess(Success success) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        session.saveOrUpdate(success);
        ts.commit();
        session.close();
    }

    public List findAllSuccess(int pageNow, int pageSize) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("SELECT c.id.sno,a.sname,b.cname,c.success,c.credit,c.id.cno FROM Student a,Classes b,Success c WHERE a.sno=c.id.sno AND b.cno=c.id.cno");
        query.setFirstResult((pageNow - 1) * pageSize);
        query.setMaxResults(pageSize);
        List list = query.list();
        ts.commit();
        session.close();
        return list;
    }

    public int findSuccessSize() {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            return session.createQuery("from Success").list().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List getschoolList(String sno) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        Query query = session.createQuery("SELECT c.id.sno,a.sname,b.cname,c.success,c.credit FROM Student a,Class b,Success c WHERE c.id.sno=? AND a.sno=c.id.cno AND b.cno=c.id.cno");
        query.setParameter(0, sno);
        List list = query.list();
        ts.commit();
        session.close();
        return list;
    }

    public void deleteSuccess(String sno, String cno) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.delete(getschool(sno, cno));
            ts.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOneschool(String sno) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.delete(getschoolList(sno));
            ts.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
