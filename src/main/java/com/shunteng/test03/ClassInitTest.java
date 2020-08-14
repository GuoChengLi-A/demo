package com.shunteng.test03;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/8/14 上午9:56
 */
public class ClassInitTest {

    public static void main(String[] args) {
        Car car = new Car();
        car.transport();
    }
}

class Fruit{
    public Fruit() {
        System.out.println("fruit init");
    }

    public void method(){

    }
}

class Car{
    private Fruit fruit;
    public Fruit transport(){
        System.out.println("car transport fruit");
        fruit.method();
        return fruit;
    }
}