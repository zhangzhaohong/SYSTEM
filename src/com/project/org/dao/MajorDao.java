package com.project.org.dao;

import com.project.org.model.Major;

import java.util.List;

public interface MajorDao {
	public Major getOneZy(Integer majorid);

	public List getAll();
}
