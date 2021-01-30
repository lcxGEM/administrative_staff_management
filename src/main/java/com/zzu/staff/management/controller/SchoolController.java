package com.zzu.staff.management.controller;

import com.zzu.staff.management.entity.School;
import com.zzu.staff.management.entity.SchoolVo;
import com.zzu.staff.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school/")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @GetMapping("queryAll")
    public List<School> queryAll(){
        return service.queryAll();
    }

    @GetMapping("queryAllVo")
    public List<SchoolVo> queryAllVo(){
        return service.queryAllVo();
    }

    @PostMapping("add")
    public int add(School school){
        return service.insert(school);
    }

    @GetMapping("delete/{id}")
    public int deleteById(@PathVariable("id")long id){
        return service.deleteById(id);
    }

    @PostMapping("update")
    public int update(School school){
        return service.update(school);
    }
}
