package com.shunteng.test;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/19 下午8:18
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(16);
        map.put(1,1);
        System.out.println(2&15);
    }
}