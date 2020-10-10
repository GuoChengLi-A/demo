package com.shunteng.test03;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description 方法：static 非static
 * @Author GCL
 * @Date 2020/10/9 上午9:47
 */
public class collectionTest {
    public static void main(String[] args) {
        ArrayList<Integer> listInts = new ArrayList<>();
        listInts.add(1);
        listInts.add(2);
        listInts.add(3);

        Integer[] arr = new Integer[5];
        listInts.toArray(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }



    public static  <T> T getInstance(Class<T> t) throws IllegalAccessException, InstantiationException {
        return t.newInstance();
    }

}
