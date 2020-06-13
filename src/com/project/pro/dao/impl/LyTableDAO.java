package com.project.pro.dao.impl;

import com.opensymphony.xwork2.ActionContext;
import com.project.pro.dao.BaseDAO;
import com.project.pro.dao.ILyTableDAO;
import com.project.pro.vo.LyTable;
import com.project.pro.vo.Test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * 2018128338 张兆泓
 * */
public class LyTableDAO extends BaseDAO implements ILyTableDAO {

    @Override
    public int getCountRec(String filter, String order, String searchType, String searchCon) {
        Session session = getSession();
        session.clear();
        String hql = "from LyTable ";
        hql = hql + dataFilter(filter, order, searchType, searchCon);
        Query qu = session.createQuery(hql);
        int num = qu.list().size();
        closeSession(session);
        return num;
    }

    @Override
    public List<LyTable> getLyList(int startR, int ReNum, String filter, String order, String searchType, String searchCon) {
        Session session = getSession();
        session.clear();
        String hql = "from LyTable ";
        hql = hql + dataFilter(filter, order, searchType, searchCon);
        Query qu = session.createQuery(hql);
        qu.setFirstResult(startR);
        qu.setMaxResults(ReNum);
        closeSession(session);
        return qu.list();
    }

    private String dataFilter(String filter, String order, String searchType, String searchCon) {

        String whereHql = "";

        if (!(filter == null || filter.equals(""))) {
            if (filter.equalsIgnoreCase("myedded")) {

                Test sessionUser = (Test) ActionContext.getContext().getSession().get("user");
                int id = sessionUser.getId();
                if (whereHql.equalsIgnoreCase("")) {
                    whereHql = whereHql + " test.id = " + id;
                } else {
                    whereHql = whereHql + " and test.id = " + id;
                }
            } else if (filter.equalsIgnoreCase("today")) {
                //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date day = new Date(System.currentTimeMillis());
                //format.format(day);
                if (whereHql.equalsIgnoreCase("")) {
                    whereHql = " lydate = '" + day + "'";
                } else {
                    whereHql = " and lydate = '" + day + "'";
                }
            } else if (filter.equalsIgnoreCase("all")) {
                whereHql = "";
            } else if (filter.equalsIgnoreCase("month")) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                //int monthInt = cal.get(Calendar.MONTH )+1;
                String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
                if (month.length() < 2) {
                    month = "0" + month;
                }
                if (whereHql.equalsIgnoreCase("")) {
                    whereHql = " lydate like '" + year + "-" + month + "%'";
                } else {
                    whereHql = " and lydate like '" + year + "-" + month + "%'";
                }
            }

        }
        if (!(searchType == null || searchType.equals("") || searchCon == null || searchCon.equals(""))) {
            if (searchType.equalsIgnoreCase("article_id")) {

                if (whereHql.equalsIgnoreCase("")) {
                    whereHql = whereHql + " id = " + searchCon;
                } else {
                    whereHql = whereHql + " and id = " + searchCon;
                }
            } else if (searchType.equalsIgnoreCase("title")) {

                if (whereHql.equalsIgnoreCase("")) {
                    whereHql = " title like %" + searchCon + "%";
                } else {
                    whereHql = " and title like %" + searchCon + "%";
                }
            } else if (searchType.equalsIgnoreCase("keyword")) {

            } else if (searchType.equalsIgnoreCase("add_user")) {

            } else if (searchType.equalsIgnoreCase("add_date")) {

            } else if (searchType.equalsIgnoreCase("save_user")) {

            }
        }
        String orderHql = "";
        if (!(order == null || order.equals(""))) {
            if (order.equalsIgnoreCase("iddown")) {
                orderHql = " order by id desc";
            } else if (order.equalsIgnoreCase("idup")) {
                orderHql = " order by id asc";
            } else if (order.equalsIgnoreCase("timedown")) {
                orderHql = " order by lydate desc";
            } else if (order.equalsIgnoreCase("timeup")) {
                orderHql = " order by lydate asc";
            }
        }
        if (!whereHql.equals("")) {
            whereHql = " where " + whereHql;
        }
        if (!orderHql.equals("")) {
            whereHql = whereHql + orderHql;
        }
        return whereHql;
    }

    @Override
    public List<LyTable> getAllLy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int save(LyTable ly) {
        Session session = getSession();
        session.clear();
        Transaction ts = session.beginTransaction();
        int sucNum;
        if (ly.getId() == null || ly.getId() == 0) {
            sucNum = (Integer) session.save(ly);
            ts.commit();
        } else {
            try {
                session.update(ly);
                ts.commit();
                sucNum = 1;
            } catch (HibernateException e) {
                sucNum = 0;
            }
        }
//		int sucNum = (Integer)session.save(ly);
//		ts.commit();
        closeSession(session);
        return sucNum;
    }

    @Override
    public LyTable getOneLy(int id) {
        Session session = getSession();
        session.clear();
        String hql = "from LyTable where id=" + id;
        Query qu = session.createQuery(hql);
        qu.setMaxResults(1);
        LyTable result = (LyTable) qu.uniqueResult();
        closeSession(session);
        return result;
    }

    @Override
    public int delete(LyTable ly) {
        Session session = getSession();
        session.clear();
        Transaction transaction = session.beginTransaction();
        session.delete(ly);
        transaction.commit();
        closeSession(session);
        return 0;
    }

}
