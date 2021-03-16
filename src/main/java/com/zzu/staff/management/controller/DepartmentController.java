package com.zzu.staff.management.controller;

import com.zzu.staff.management.entity.Department;
import com.zzu.staff.management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("queryAll")
    public List<Department> queryAll(){
        return departmentService.queryAll();
    }
}
