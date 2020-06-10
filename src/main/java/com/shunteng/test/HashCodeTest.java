package com.shunteng.test;

import java.util.Objects;

/**
 * @Description 测试equals与hashcode必须同时重写的原因
 * @Author GCL
 * @Date 2020/5/26 下午1:51
 */
public class HashCodeTest {

    public static void main(String[] args) {
        Fruit fruit = new Fruit("苹果",23,50);
        Fruit fruit2= new Fruit("苹果",23,50);
        System.out.println(fruit.equals(fruit2));
        System.out.println("fruit hashcode:"+fruit.hashCode());
        System.out.println("fruit2 hashcode:"+fruit2.hashCode());
    }

}

class Fruit{
    private String name;
    private Integer count;
    private Integer height;

    public Fruit(String name, Integer count, Integer height) {
        this.name = name;
        this.count = count;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) &&
                Objects.equals(count, fruit.count) &&
                Objects.equals(height, fruit.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, height);
    }
}