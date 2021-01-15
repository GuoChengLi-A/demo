package com.shunteng.multiImpl;

/**
 * @Description: 鸟人
 * @Author: GCL
 * @Date: 2021/1/15 14:33
 */
public class BirdPeople implements Bird, People {

    @Override
    public void fly() {
        System.out.println("i can fly");
    }

    @Override
    public void communicate() {
        System.out.println("i can communicate");
    }

    @Override
    public void think() {
        System.out.println("i can think");
    }
}
