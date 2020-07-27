package com.shunteng.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/6 下午2:21
 */
public class ArraysTest {
    public static void main(String[] args) {
        List<String> listStrings = new ArrayList<>(16);
        for (int i = 0; i < 16; i++) {
            listStrings.add(i + "");
        }
        System.out.println(listStrings.subList(0, 3));//左闭右开[0, 3)

    }
}
