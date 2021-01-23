package com.zzu.staff.management;

import com.zzu.staff.management.entity.SchoolType;
import com.zzu.staff.management.service.SchoolTypeService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringbootApplication.class)
@RunWith(SpringRunner.class)
public class SchoolTest {

    @Autowired
    private SchoolTypeService schoolTypeService;

    //Logger logger = LogManager.getLogger("AsyncFileLogger");

    @Test
    public void TestService(){
        List<SchoolType> schoolTypes = schoolTypeService.queryAll();
       // logger.info("--------#######test#########---------->"+schoolTypes.toString());
        System.out.println("--------#######test#########---------->"+schoolTypes.toString());
    }
}
