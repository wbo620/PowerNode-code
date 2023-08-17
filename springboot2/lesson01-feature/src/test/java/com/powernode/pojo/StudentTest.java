package com.powernode.pojo;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void test01() {
        Student zhangsan = new Student(001,"张三","北京");
        System.out.println(zhangsan);

    }
}