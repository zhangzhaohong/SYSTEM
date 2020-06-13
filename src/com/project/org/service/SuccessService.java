package com.project.org.service;

import com.project.org.model.Success;

import java.util.List;

public interface SuccessService {
    Success getschool(String sno, String cno);

    void saveorupdateSuccess(Success success);

    List findAllSuccess(int pageNow, int pageSize);

    int findSuccessSize();

    List getschoolList(String sno);

    void deleteSuccess(String sno, String cno);

    void deleteOneschool(String sno);
}
