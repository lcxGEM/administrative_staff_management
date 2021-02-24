package com.zzu.staff.management.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.staff.management.entity.School;
import com.zzu.staff.management.entity.SchoolData;
import com.zzu.staff.management.entity.SchoolVo;
import com.zzu.staff.management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/school/")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @GetMapping("queryAll")
    public List<School> queryAll(){
        return service.queryAll();
    }

    @GetMapping("queryAllVo/{pageNum}/{pageSize}/{sName}/{sType}")
    public PageInfo<SchoolVo> queryAllVo(@PathVariable("pageNum")int pageNum,
                                         @PathVariable("pageSize") int pageSize,
                                         @PathVariable("sName") String sName,
                                         @PathVariable("sType")Integer sType){
        PageHelper.startPage(pageNum, pageSize);
        List<SchoolVo> schoolVoList = service.queryAllVo(sName,sType);
        PageInfo<SchoolVo> pageInfo = new PageInfo<>(schoolVoList);
        return pageInfo;
    }

    @GetMapping("queryAllData")
    public Map<String,Object> queryAllData(){
        List<School> schools = service.queryAll();

        List<SchoolData> schoolDatas = new ArrayList<>();
        for (School s: schools) {
            SchoolData schoolData = new SchoolData(s.getId().toString(),s.getName());
            schoolDatas.add(schoolData);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", schoolDatas);
        map.put("count", schoolDatas.size());
        map.put("msg", "成功");
        return map;
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

    @GetMapping("deleteAll/{ids}")
    public int deleteAll(@PathVariable("ids")String ids){
        String [] ida = ids.split(",");
        int a=0;
        for (String id:ida) {
            if(id.length()>0){
                Long aid = new Long(id);
                if(aid>0){
                    int b = service.deleteById(aid);
                    a+=b;
                }
            }
        }
        return a;
    }
}
