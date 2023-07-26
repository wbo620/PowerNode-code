package com.powernode.spring6.bean;

public class Teacher {
    private String name;
    private Student student;


    public Teacher() {
    }

    public Teacher(String name, Student student) {
        this.name = name;
        this.student = student;
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
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * 设置
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString() {
        return "Teacher{name = " + name + ", student = " + student.getName() + "}";
    }
}
