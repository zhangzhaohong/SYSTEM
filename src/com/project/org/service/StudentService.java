package com.project.org.service;

import com.project.org.model.Student;

import java.util.List;

public interface StudentService {
	public List findAll(int pageNow, int pageSize);
	public int findstudentSize();
	public Student find(String sno);
	public void delete(String sno);
	public void update(Student student);
	public void save(Student student);
}
