package com.shunteng.test03;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/9/4 上午11:10
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer,Integer> paris2;
        HashMap<Integer, Integer> paris = new HashMap<>();
        paris.put(1, 10);
       /* paris.put(2,20);
        paris.put(3,30);*/

        System.out.println(paris);
        paris2=paris;
        paris2.put(2,100);
        System.out.println(paris);
    }
}