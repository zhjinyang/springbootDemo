package com.codeyancy.cn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Zjy
 * @date 2021/4/12 17:31
 */
@Data
public class Employee {
    private Long employeeId;

    private String employeeName;

    private String employeeImg;

    private String employeeEmail;

    private String employeeDept;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date employeeTime;


}
