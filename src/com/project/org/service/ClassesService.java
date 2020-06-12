package com.project.org.service;

import com.project.org.model.Classes;

import java.util.List;

public interface ClassesService {
	public List findAll(int pageNow, int pageSize);
	public int findKcSize();
	public Classes find(String cno);
}
