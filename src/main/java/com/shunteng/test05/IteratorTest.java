package com.shunteng.test05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/9 下午2:10
 */
public class IteratorTest {

    public static void main(String[] args) {
        ArrayList<Integer> listInts = new ArrayList<>();
        listInts.add(1);
        listInts.add(2);
        listInts.add(3);
        listInts.add(4);
        System.out.println(listInts);

        Iterator<Integer> iterator = listInts.iterator();
        Integer next;
        while (iterator.hasNext()){
            next = iterator.next();
            System.out.println(next);
            if (next == 2) {
                iterator.remove();
            }
        }
        System.out.println(listInts);
    }
}