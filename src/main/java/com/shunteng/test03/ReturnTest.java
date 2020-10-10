package com.shunteng.test03;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/9/14 下午2:42
 */
public class ReturnTest {

    private static int add(int i1, int i2) {
        return i1 + i2;
    }

    public static void main(String[] args) {
        int add = add(1, 2);
        System.out.println(add);
    }
}