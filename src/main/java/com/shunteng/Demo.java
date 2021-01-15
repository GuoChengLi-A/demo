package com.shunteng;

import java.lang.reflect.Field;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/4 09:43
 */
public class Demo {

    private String name;
    public Integer age;

    public Demo(String name, Integer age) {
        this.name = name;
        this.age = age;
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
