package com.project.org.dao;

import com.project.org.model.Student;

import java.util.List;

public interface StudentDao {
	public List findAll(int pageNow, int pageSize);
	public int findstudentSize();

	public Student find(String sno);

	public void delete(String sno);

	public void update(Student student);

	public void save(Student student);
}
