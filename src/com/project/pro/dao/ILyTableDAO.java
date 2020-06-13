package com.project.pro.dao;

import com.project.pro.vo.LyTable;

import java.util.List;

/**
 * 2018128338 张兆泓
 */
public interface ILyTableDAO {

    int getCountRec(String filter, String order, String searchType, String searchCon);

    List<LyTable> getLyList(int startR, int ReNum, String filter, String order, String searchType, String searchCon);

    List<LyTable> getAllLy();

    LyTable getOneLy(int id);

    int delete(LyTable ly);

    int save(LyTable ly);

}
