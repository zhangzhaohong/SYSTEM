package com.project.org.service;

import com.project.org.model.Classes;

import java.util.List;

public interface ClassesService {
    List findAll(int pageNow, int pageSize);

    int findKcSize();

    Classes find(String cno);
}
