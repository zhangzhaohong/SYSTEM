package com.project.org.dao;

import com.project.org.model.Success;

import java.util.List;

public interface SuccessDao {
	public Success getschool(String sno, String cno);
	public void saveorupdateSuccess(Success success);
	public List findAllSuccess(int pageNow, int pageSize);
	public int findSuccessSize();
	public List getschoolList(String sno);
	public void deleteSuccess(String sno, String cno);
	public void deleteOneschool(String sno);
}
