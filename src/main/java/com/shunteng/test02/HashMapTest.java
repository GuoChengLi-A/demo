package com.shunteng.test02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/20 下午3:31
 */
public class HashMapTest {
    public static void main(String[] args) {
        int h = 1;
        System.out.println(h >>> 16);//无符号右移0000000000000000  1000001111000保证二进制一致性
        Map<String, Object> map = new HashMap<>();
        map.put("age",12);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getValue());
        }
        Set<String> strings = map.keySet();
        map.values().forEach(System.out::print);
//        System.out.println(strings);
    }
}