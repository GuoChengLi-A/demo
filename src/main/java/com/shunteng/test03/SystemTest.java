package com.shunteng.test03;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/8/14 下午4:05
 */
public class SystemTest {

    public static void main(String[] args) {
        int [] a=new int[15];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        a[4]=5;
        System.arraycopy(a,1,a,2,3);
        Arrays.stream(a).forEach(System.out::println);
    }

}