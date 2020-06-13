package com.project.pro.dao;

import com.project.pro.vo.LyTable;

import java.util.List;

/**
 * 2018128338 张兆泓
 * */
public interface ILyTableDAO {
	
	public int getCountRec(String filter, String order, String searchType, String searchCon);
	public List<LyTable> getLyList(int startR, int ReNum, String filter, String order, String searchType, String searchCon);
	public List<LyTable> getAllLy();
	
	public LyTable getOneLy(int id);
	public int delete(LyTable ly);;
	public int save(LyTable ly);
	
}
