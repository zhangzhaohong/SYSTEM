package com.project.org.service.imp;

import com.project.org.dao.StudentDao;
import com.project.org.dao.SuccessDao;
import com.project.org.model.Student;
import com.project.org.service.StudentService;

import java.util.List;

public class StudentServiceManage implements StudentService {
    private StudentDao studentDao;
    private SuccessDao successDaoDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List findAll(int pageNow, int pageSize) {
        return studentDao.findAll(pageNow, pageSize);
    }

    public int findstudentSize() {
        return studentDao.findstudentSize();
    }

    public Student find(String sno) {
        return studentDao.find(sno);
    }

    public void delete(String sno) {
        studentDao.delete(sno);
        successDaoDao.deleteOneschool(sno);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public SuccessDao getSuccessDaoDao() {
        return successDaoDao;
    }

    public void setSuccessDaoDao(SuccessDao successDaoDao) {
        this.successDaoDao = successDaoDao;
    }

}
