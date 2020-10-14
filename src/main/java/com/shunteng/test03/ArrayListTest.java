package com.shunteng.test03;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 上午10:19
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> listInts = new ArrayList<>();
        listInts.add(2);
        listInts.add(3);
        listInts.add(2);
        listInts.add(3);


        /*ArrayList<Integer> listInts2 = new ArrayList<>();
        listInts2.add(2);
        listInts2.add(3);
        listInts.retainAll(listInts2);


        ListIterator<Integer> integerListIterator = listInts.listIterator(0);
        System.out.println(integerListIterator);*/

        Spliterator<Integer> spliterator = listInts.spliterator();
        System.out.println(spliterator.estimateSize());


    }
}