package com.zzu.staff.management.controller;

import com.zzu.staff.management.entity.Manager;
import com.zzu.staff.management.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
