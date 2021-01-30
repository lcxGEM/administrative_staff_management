package com.zzu.staff.management.mapper;

import com.zzu.staff.management.entity.Manager;
import com.zzu.staff.management.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {
    List<Manager> queryAll();

    Manager queryById(int id);

    int insert(Manager manager);

    int deleteById(int id);

    int update(Manager manager);
}
