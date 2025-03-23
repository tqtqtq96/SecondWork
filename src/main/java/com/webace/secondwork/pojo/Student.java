package com.webace.secondwork.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("student")
public class Student {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String address;
}