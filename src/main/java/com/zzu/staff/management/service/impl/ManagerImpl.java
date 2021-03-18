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
    public List<Manager> queryAll(String name,int department) {

        String trim = name.trim();
        if(trim.length()==0&&department==-1){
            return managerMapper.queryAll();
        }else {
            return managerMapper.searchAll(trim,department);
        }
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

    @Override
    public int changePasswd(int id, String passwd) {
        return managerMapper.changePasswd(id,passwd);
    }
}
