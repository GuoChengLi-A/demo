package com.mianshi;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/19 20:05
 */
public class InstanceOfTest {

    public static void main(String[] args) {
        class A{}

        class B extends A{}

        class C extends A{}

        class D extends B{}

        A obj = new D();

        System.out.println(obj instanceof B);

        System.out.println(obj instanceof C);

        System.out.println(obj instanceof D);

        System.out.println(obj instanceof A);
    }
}
