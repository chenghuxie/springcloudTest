package com.sun3d.why.model;

import java.io.Serializable;

/**
 * Created by xiech on 2019/4/1 0001.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1143262491957777839L;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
