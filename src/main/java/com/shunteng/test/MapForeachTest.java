package com.shunteng.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/20 上午9:15
 */
public class MapForeachTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Set<Integer> integers = map.keySet();//获取所有key 在通过foreach遍历取出value；遍历了两次

    }
}