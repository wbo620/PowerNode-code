package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 班级信息
 *
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> stus;
}
