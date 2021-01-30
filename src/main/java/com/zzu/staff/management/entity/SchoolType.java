package com.zzu.staff.management.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SchoolType {

    private Integer id;

    private String typeName;

    private Float schoolIndex;

    private Float undergraduateIndex;

    private Float masterIndex;

    private Float doctorIndex;

    private Float sumIndex;

    public Float getSumIndex() {
        Float sum = this.doctorIndex*this.masterIndex*this.undergraduateIndex;
        BigDecimal b = new BigDecimal(sum);
        float f1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        this.sumIndex = f1;
        return sumIndex;
    }
}
