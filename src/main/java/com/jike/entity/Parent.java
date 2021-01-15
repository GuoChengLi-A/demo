package com.jike.entity;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/14 22:09
 */
public class Parent {
    //String 2 String
    private String firstName;

    private String lastName;
    //String 2 Integer
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
