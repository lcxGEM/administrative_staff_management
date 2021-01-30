package com.zzu.staff.management.service.impl;

import com.zzu.staff.management.entity.Manager;
import com.zzu.staff.management.mapper.ManagerMapper;
import com.zzu.staff.management.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public List<Manager> queryAll() {
        return managerMapper.queryAll();
    }

    @Override
    public Manager queryById(int id) {
        return managerMapper.queryById(id);
    }

    @Override
    public int insert(Manager manager) {
        return managerMapper.insert(manager);
    }

    @Override
    public int deleteById(int id) {
        return managerMapper.deleteById(id);
    }

    @Override
    public int update(Manager manager) {
        return managerMapper.update(manager);
    }
}
