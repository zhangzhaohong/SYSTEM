package com.project.org.service.imp;

import com.project.org.dao.MajorDao;
import com.project.org.model.Major;
import com.project.org.service.MajorService;

import java.util.List;

public class MajorServiceManage implements MajorService{
	private MajorDao majorDao;
	public Major getOneZy(Integer majorid){
		return majorDao.getOneZy(majorid);
	}
	public List getAll(){
		return majorDao.getAll();
	}
	public MajorDao getMajorDao() {
		return majorDao;
	}
	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}
	
}
