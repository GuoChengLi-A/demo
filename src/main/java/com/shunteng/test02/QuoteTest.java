package com.shunteng.test02;

import java.util.ArrayList;
import java.util.List;

public class QuoteTest {

//    private static List<Integer> append(List<Integer> list){
//        list.add(1);
//        return list;
//    }
//
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
//        System.out.println(list);
//
//        List<Integer> append = append(list);
//        System.out.println(append);
//
//    }

    static int count=0;

    public QuoteTest() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        QuoteTest i1 = new QuoteTest();

        QuoteTest i2 = new QuoteTest();
    }
}


