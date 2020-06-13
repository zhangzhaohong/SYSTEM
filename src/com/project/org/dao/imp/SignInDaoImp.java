package com.project.org.dao.imp;

import com.project.org.dao.BaseDAO;
import com.project.org.dao.SignInDao;
import com.project.org.model.SignIn;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class SignInDaoImp extends BaseDAO implements SignInDao {
    public SignIn find(String sno, String stupwd) {
        String hql = "from SignIn u where u.sno=?1 and u.stupwd=?2";
        SignIn user = null;
        Session session = getSession();
        session.clear();
        Query query = session.createQuery(hql);
        query.setParameter(1, sno);
        query.setParameter(2, stupwd);
        List users = query.list();
        Iterator it = users.iterator();
        while (it.hasNext()) {
            if (users.size() != 0) {
                user = (SignIn) it.next();
            }
        }
        closeSession(session);
        return user;
    }
}
