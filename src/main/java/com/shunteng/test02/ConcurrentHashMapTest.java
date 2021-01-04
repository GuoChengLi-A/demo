package com.shunteng.test02;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();

        map.put(123L, 123);
        map.remove(123123L);

        String str="123L:123";
        String[] arr = str.split(":");
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
