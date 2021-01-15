package com.shunteng.decoreate;

/**
 * @Description: 原型模式
 * @Author: GCL
 * @Date: 2021/1/8 16:29
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype data = new Realizetype();

        Realizetype clone = (Realizetype)data.clone();


    }
}
