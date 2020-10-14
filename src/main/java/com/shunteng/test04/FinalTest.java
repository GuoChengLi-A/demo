package com.shunteng.test04;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/12 上午11:03
 */
public class FinalTest {

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        arr1[0] = 1;


        int[] arr2 = new int[5];
        arr2[0] = 2;
        arr2[1] = 2;
        arr2[2] = 2;
        arr2[3] = 2;
        arr2[4] = 2;

        System.arraycopy(arr1, 0, arr2, 3,2);

        Arrays.stream(arr2).forEach(System.out::println);
    }
}