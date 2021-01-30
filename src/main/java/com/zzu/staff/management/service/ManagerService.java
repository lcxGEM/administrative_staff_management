package com.zzu.staff.management.service;

import com.zzu.staff.management.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> queryAll();

    Manager queryById(int id);

    int insert(Manager manager);

    int deleteById(int id);

    int update(Manager manager);
}
