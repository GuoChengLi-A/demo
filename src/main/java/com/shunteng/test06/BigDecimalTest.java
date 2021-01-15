package com.shunteng.test06;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/6 10:04
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        ArrayList<Fruit> list = new ArrayList<>();

        Fruit fruit = new Fruit();

        for (int i = 0; i < 3; i++) {
            fruit.setName("苹果");
            fruit.setWeight((double) 1);
            list.add(fruit);
        }
        list.forEach(System.out::println);
    }
}

class Fruit {
    private String name;
    private Double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
