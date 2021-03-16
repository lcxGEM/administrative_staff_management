package com.zzu.staff.management.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.staff.management.entity.Manager;
import com.zzu.staff.management.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 管理员业务
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 管理员登录
     */
    @GetMapping("/doLogin/{id}/{passwd}")
    public Manager doLogin(@PathVariable("id") int id, @PathVariable("passwd") String passwd){
        Manager manager = managerService.queryById(id);
        if(manager!=null){
            if(manager.getPasswd().equals(passwd)){
                return manager;
            }else{
                return new Manager();
            }
        }else{
            return new Manager();
        }
    }

    @GetMapping("/queryAll/{pageNum}/{pageSize}/{name}/{department}")
    public PageInfo<Manager> queryAll(@PathVariable("pageNum")int pageNum,
                                      @PathVariable("pageSize") int pageSize,
                                      @PathVariable("name")String name,
                                      @PathVariable("department")int department){
        PageHelper.startPage(pageNum, pageSize);
        List<Manager> schoolVoList = managerService.queryAll(name,department);
        PageInfo<Manager> pageInfo = new PageInfo<>(schoolVoList);
        return pageInfo;
    }

    @GetMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id")Integer id){
        return managerService.deleteById(id);
    }

    @PostMapping("/insert")
    public int insert(Manager manager){
        return managerService.insert(manager);
    }

    @PostMapping("/updateById")
    public int updateById(Manager manager){
        return managerService.update(manager);
    }
}
