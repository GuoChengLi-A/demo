package com.shunteng.test05;

import sun.security.action.GetPropertyAction;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/4 下午2:45
 */
public class Test {
    private final List<Integer> list;

    public Test(List<Integer> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Test test = new Test(list);
        System.out.println(test.list);
        list.add(1);
        list.add(2);
        System.out.println(list);

        String var1 = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.ch.bugLevel"));
        System.out.println(var1);

        Properties cn = System.getProperties();
        String s = String.valueOf(cn);
        Arrays.stream(s.split(",")).forEach(System.out::println);
//        System.out.println(cn);
    }
}