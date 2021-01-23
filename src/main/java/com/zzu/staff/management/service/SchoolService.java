package com.zzu.staff.management.service;

import com.zzu.staff.management.entity.School;

import java.util.List;

public interface SchoolService {
    List<School> queryAll();

    School queryById(long id);

    int insert(School school);

    int deleteById(long id);

    int update(School school);
}
