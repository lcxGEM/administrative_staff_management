package com.zzu.staff.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolType {

    private Integer id;

    private String typeName;

    private Double schoolIndex;

    private Double undergraduateIndex;

    private Double masterIndex;

    private Double doctorIndex;
}
