package com.project.org.dao;

import com.project.org.model.Student;

import java.util.List;

public interface StudentDao {
    List findAll(int pageNow, int pageSize);

    int findstudentSize();

    Student find(String sno);

    void delete(String sno);

    void update(Student student);

    void save(Student student);
}
