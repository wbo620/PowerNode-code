package com.powernode.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
    private List<String> names;
    private Set<String> addres;

    private Map<String,String> map;

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addres=" + addres +
                ", map=" + map +
                '}';
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddres(Set<String> addres) {
        this.addres = addres;
    }

}
