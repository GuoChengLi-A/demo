package com.shunteng.test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/25 下午8:36
 */
public class KMPTest {
    //有这样一个需求：返回主串中与模式串相匹配的索引位置
    private static int traditionalMethod(String mainString, String patternString) {
        for (int i = 0; i < mainString.length() - patternString.length() + 1; i++) {
            if (mainString.startsWith(patternString, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int[] getNext(String patternString) {
        char[] p = patternString.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
//        int i = KMPTest.traditionalMethod("abcdefga", "fag");
//        System.out.println("主串中与模式串相匹配的索引位置：" + i);
        int[] abcabbs = KMPTest.getNext("abcabb");
        Arrays.stream(abcabbs).forEach(System.out::println);
    }
}