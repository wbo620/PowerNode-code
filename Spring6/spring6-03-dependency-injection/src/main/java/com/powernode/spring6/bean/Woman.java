package com.powernode.spring6.bean;

import java.util.Arrays;

public class Woman {
  private String name;

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
