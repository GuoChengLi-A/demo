package com.shunteng.multiImpl;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/15 14:34
 */
public class Main {

    public static void main(String[] args) {
        Bird bird = new BirdPeople();
        bird.communicate();

        People people = new BirdPeople();
        people.communicate();

    }
}
