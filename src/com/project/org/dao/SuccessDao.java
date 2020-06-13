package com.project.org.dao;

import com.project.org.model.Success;

import java.util.List;

public interface SuccessDao {
    Success getschool(String sno, String cno);

    void saveorupdateSuccess(Success success);

    List findAllSuccess(int pageNow, int pageSize);

    int findSuccessSize();

    List getschoolList(String sno);

    void deleteSuccess(String sno, String cno);

    void deleteOneschool(String sno);
}
