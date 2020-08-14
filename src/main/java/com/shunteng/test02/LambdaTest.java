package com.shunteng.test02;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/8/3 下午2:07
 */
public class LambdaTest {


    public static void main(String[] args) {
        Passenger chinesePassanger = new ChinesePassenger();
        chinesePassanger.passThroughImmigration();
        //Method com/shunteng/test02/Passenger.passThroughImmigration:()V 如何找到目标方法

    }
}

class Car {

    public void run() {
        System.out.println("Car is running");
    }
}

//如果父类重载的方法被子类重写了；那就是重写了呗
class KartCar extends Car {
    @Override
    public void run() {
        System.out.println("KartCar is running");
    }

}

abstract class Passenger {
    abstract void passThroughImmigration();
}

class ChinesePassenger extends Passenger{

    @Override
    public void passThroughImmigration() {
        System.out.println("chinesePassanger is running");
    }
}