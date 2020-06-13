package com.project.org.service.imp;

import com.project.org.dao.ClassesDao;
import com.project.org.model.Classes;
import com.project.org.service.ClassesService;

import java.util.List;

public class ClassesServiceManage implements ClassesService {
    private ClassesDao classesDao;

    public List findAll(int pageNow, int pageSize) {
        return classesDao.findAll(pageNow, pageSize);
    }

    public int findKcSize() {
        return classesDao.findClassesSize();
    }

    public Classes find(String cno) {
        return classesDao.find(cno);
    }

    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

}
