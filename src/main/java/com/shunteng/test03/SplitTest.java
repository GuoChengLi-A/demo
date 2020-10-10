package com.shunteng.test03;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/9/21 下午7:23
 */
public class SplitTest {

    public static void main(String[] args) {
        String str="123123";
        String[] split = str.split(",");

        Arrays.stream(split).forEach(System.out::println);

        int i=17;
        System.out.println(17+(17>>1));
    }
}