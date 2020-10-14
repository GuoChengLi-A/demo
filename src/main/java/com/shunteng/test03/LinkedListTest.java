package com.shunteng.test03;

import java.util.LinkedList;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 下午2:08
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        Integer last = linkedList.getLast();
        System.out.println(last);
    }
}