package com.project.org.service.imp;

import com.project.org.dao.SuccessDao;
import com.project.org.model.Success;
import com.project.org.service.SuccessService;

import java.util.List;

public class SuccessServiceManage implements SuccessService {
    private SuccessDao successDao;

    public Success getschool(String sno, String cno) {
        return successDao.getschool(sno, cno);
    }

    public void saveorupdateSuccess(Success success) {
        successDao.saveorupdateSuccess(success);
    }

    public List findAllSuccess(int pageNow, int pageSize) {
        return successDao.findAllSuccess(pageNow, pageSize);
    }

    public int findSuccessSize() {
        return successDao.findSuccessSize();
    }

    public List getschoolList(String sno) {
        return successDao.getschoolList(sno);
    }

    public void deleteSuccess(String sno, String cno) {
        successDao.deleteSuccess(sno, cno);
    }

    public void deleteOneschool(String sno) {
        successDao.deleteOneschool(sno);
    }

    public SuccessDao getSuccessDao() {
        return successDao;
    }

    public void setSuccessDao(SuccessDao successDao) {
        this.successDao = successDao;
    }

}
