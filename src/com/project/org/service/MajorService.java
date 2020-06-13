package com.project.org.service;

import com.project.org.model.Major;

import java.util.List;

public interface MajorService {
    Major getOneZy(Integer majorid);

    List getAll();
}
