package com.zzu.staff.management.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.staff.management.entity.Staff;
import com.zzu.staff.management.entity.StaffStatus;
import com.zzu.staff.management.entity.StaffVo;
import com.zzu.staff.management.service.StaffService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 职工前端展示信息
     * 分页 模糊查询功能
     */
    @GetMapping("queryAllVo/{pageNum}/{pageSize}/{sName}/{gsType}/{msType}/{dsType}/{depart}/{status}/{stId}")
    public PageInfo<StaffVo> queryAllVo(@PathVariable("pageNum")int pageNum,
                                        @PathVariable("pageSize") int pageSize,
                                        @PathVariable("sName")String sName, //模糊查询数据：姓名关键字
                                        @PathVariable("gsType")Integer gsType, //模糊查询数据：学校关键字
                                        @PathVariable("msType")Integer msType, //
                                        @PathVariable("dsType")Integer dsType,
                                        @PathVariable("depart")Integer depart,
                                        @PathVariable("status")Integer status,
                                        @PathVariable("stId")Integer stId){ //

        PageHelper.startPage(pageNum, pageSize);
        List<StaffVo> schoolVoList = staffService.queryAllVo(sName,gsType,msType,dsType,depart,status,stId);
        PageInfo<StaffVo> pageInfo = new PageInfo<>(schoolVoList);
        return pageInfo;
    }

//    @PostMapping("add")
//    public int add(Staff staff){
//        return staffService.insert(staff);
//    }

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

    /**
     * 从数据库导出Excel数据
     * @param response
     */
    @GetMapping("downloadAll/{stId}")
    public void downloadAll(HttpServletResponse response,@PathVariable("stId") Integer stId){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("郑州大学教师学历排名表");
        List<StaffVo> classmateList = staffService.queryAllVo(" ",0,0,0,-1,-1,stId);
        SimpleDateFormat a = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = "TeacherCompositeIndex_"+ a.format(new Date()) + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "教师类型", "姓名", "性别", "联系方式","身份证","出生日期","本科学校","硕士学校","博士学校","综合指数","评价","院系","状态"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        //在表中存放查询到的数据放入对应的列
        for (StaffVo teacher : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(teacher.getTeacherType());
            row1.createCell(1).setCellValue(teacher.getName());
            row1.createCell(2).setCellValue(teacher.getSex()==1?"男":"女");
            row1.createCell(3).setCellValue(teacher.getTel());
            row1.createCell(4).setCellValue(teacher.getIdentity());
            row1.createCell(5).setCellValue(sdf.format(teacher.getBirthday()));
            row1.createCell(6).setCellValue(teacher.getuSchoolName());
            row1.createCell(7).setCellValue(teacher.getmSchoolName());
            row1.createCell(8).setCellValue(teacher.getdSchoolName());
            row1.createCell(9).setCellValue(teacher.getCompositeIndex());
            row1.createCell(10).setCellValue(teacher.getEvaluation());
            row1.createCell(11).setCellValue(teacher.getDepartmentName());
            row1.createCell(12).setCellValue(StaffStatus.getStatus(teacher.getStatus()));
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("changestatus/{id}/{status}")
    public int changeStatus(@PathVariable("id")long id,@PathVariable("status")int status){
        return staffService.changeStatus(id,status);
    }
}
