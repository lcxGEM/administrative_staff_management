package com.zzu.staff.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SchoolData  implements Serializable {

    private String code;

    private String value;
}


