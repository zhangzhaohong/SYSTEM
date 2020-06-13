package com.project.org.dao;

import com.project.org.model.Classes;

import java.util.List;

public interface ClassesDao {
    List findAll(int pageNow, int pageSize);

    int findClassesSize();

    Classes find(String cno);
}
