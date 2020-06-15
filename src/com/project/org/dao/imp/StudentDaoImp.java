package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.StudentDao;
import com.project.org.model.Student;
import com.project.pro.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImp extends BaseDAO implements StudentDao {
    public List findAll(int pageNow, int pageSize) {
        Session session = getSession();
        List list = null;
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Student order by sno");
            int firstResult = (pageNow - 1) * pageSize;
            query.setFirstResult(firstResult);
            query.setMaxResults(pageSize);
            list = query.list();
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
        return list;
    }

    public int findstudentSize() {
        Session session = getSession();
        int num = 0;
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            num = session.createQuery("from Student").list().size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
        return num;
    }

    public Student find(String sno) {
        Session session = getSession();
        Student student = null;
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Student where sno=?1");
            query.setParameter(1, sno);
            query.setMaxResults(1);
            student = (Student) query.uniqueResult();
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
        return student;
    }

    public void delete(String sno) {
        Session session = getSession();
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            Student student = find(sno);
            session.delete(student);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
    }

    public void update(Student student) {
        Session session = getSession();
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            session.update(session.merge(student));
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
    }

    public void save(Student student) {
        Session session = getSession();
        try {
            session.clear();
            Transaction ts = session.beginTransaction();
            session.save(student);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeSession(session);
    }
}
