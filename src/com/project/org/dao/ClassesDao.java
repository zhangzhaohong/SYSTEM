package com.project.org.dao;

import com.project.org.model.Classes;

import java.util.List;

public interface ClassesDao {
	public List findAll(int pageNow, int pageSize);
	public int findClassesSize();
	public Classes find(String cno);
}
