package com.project.pro.dao.impl;

import com.project.LogUtil;
import com.project.pro.dao.BaseDAO;
import com.project.pro.dao.IUserTableDAO;
import com.project.pro.factory.HibernateSessionFactory;
import com.project.pro.vo.Test;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserTableDAO extends BaseDAO implements IUserTableDAO {

    @Override
    public Test validatTest(String username, String userpwd, String usertype) {
        //String hql = "from Test where username=? and userpwd=? and usertype=?";
        String hql = "from Test where username=?1 and userpwd=?2 and usertype=?3";
        //String hql = "select * from `test` where username='" + username + "' and userpwd='" + userpwd + "' and usertype='" + usertype + "'";
        new LogUtil().printLn(hql);

        Query query = getSession()
                .createQuery(hql);

        List users = query
                .setParameter(1, username)
                .setParameter(2, userpwd)
                .setParameter(3, usertype)
                .getResultList();

        if (users.size() > 0) {
            return (Test) users.get(0);
        }

        return null;
    }

    @Override
    public int saveUser(Test user) {
        Session session = getSession();
        Transaction ts = session.beginTransaction();
        int sucNum = (Integer) session.save(user);

        ts.commit();

        HibernateSessionFactory.closeSession();

        return sucNum;
    }

}
