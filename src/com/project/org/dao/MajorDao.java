package com.project.org.dao;

import com.project.org.model.Major;

import java.util.List;

public interface MajorDao {
    Major getOneZy(Integer majorid);

    List getAll();
}
