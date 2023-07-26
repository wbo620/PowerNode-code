package com.powernode.spring6.bean;

public class Student {
    private String name;
    private Teacher teacher;


    public Student() {
    }

    public Student(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * 设置
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String toString() {
        return "Student{name = " + name + ", teacher = " + teacher.getName() + "}";
    }
}
