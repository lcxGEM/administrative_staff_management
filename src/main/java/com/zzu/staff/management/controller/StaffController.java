package com.zzu.staff.management.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.staff.management.entity.SchoolVo;
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

    @GetMapping("queryAllVo/{pageNum}/{pageSize}/{sName}/{gsType}/{msType}/{dsType}")
    public PageInfo<StaffVo> queryAllVo(@PathVariable("pageNum")int pageNum,
                                        @PathVariable("pageSize") int pageSize,
                                        @PathVariable("sName")String sName,
                                        @PathVariable("gsType")Integer gsType,
                                        @PathVariable("msType")Integer msType,
                                        @PathVariable("dsType")Integer dsType){

        PageHelper.startPage(pageNum, pageSize);
        List<StaffVo> schoolVoList = staffService.queryAllVo(sName,gsType,msType,dsType);
        PageInfo<StaffVo> pageInfo = new PageInfo<>(schoolVoList);
        return pageInfo;
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

    @PostMapping("staffAdd")
    public int staffAdd(Staff staff){
        //-1出错
        return staffService.staffAdd(staff);
    }

    @GetMapping("deleteAll/{ids}")
    public int deleteAll(@PathVariable("ids")String ids){
        String [] ida = ids.split(",");
        int a=0;
        for (String id:ida) {
            if(id.length()>0){
                Long aid = new Long(id);
                if(aid>0){
                    int b = staffService.deleteById(aid);
                    a+=b;
                }
            }
        }
        return a;
    }
}
