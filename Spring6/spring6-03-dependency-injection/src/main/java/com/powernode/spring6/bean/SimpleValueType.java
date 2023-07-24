package com.powernode.spring6.bean;

public class SimpleValueType {
    private int age;
    private Integer age2;
    private String username;
    private boolean flag;
    private Boolean flag2;
    private Season season;

    private char c;
    private Character c2;
    private Class clazz;

    public void setAge(int age) {
        this.age = age;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "SimpleValueType{" +
                "age=" + age +
                ", age2=" + age2 +
                ", username='" + username + '\'' +
                ", flag=" + flag +
                ", flag2=" + flag2 +
                ", season=" + season +
                ", c=" + c +
                ", c2=" + c2 +
                ", clazz=" + clazz +
                '}';
    }
}
