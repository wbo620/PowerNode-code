package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 学生信息
 *
 * 多对一: 谁在前面谁是主表,
 *  多在前,此时多的一方是Student表
 *
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Student {
    private Integer sid;
    private String sname;
    private  Clazz clazz; //一的一方

}
