package com.zzu.staff.management.controller;

import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.entity.StaffVo;
import com.zzu.staff.management.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff/")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("queryAll")
    public List<Staff> queryAll(){
        return staffService.queryAll();
    }

    @GetMapping("queryAllVo")
    public List<StaffVo> queryAllVo(){
        return staffService.queryAllVo();
    }

    @PostMapping("add")
    public int add(Staff staff){
        return staffService.insert(staff);
    }
    @GetMapping("delete/{id}")
    public int delete(@PathVariable("id")long id){
        return staffService.deleteById(id);
    }

    @PostMapping("update")
    public int update(Staff staff){
        return staffService.update(staff);
    }
}
