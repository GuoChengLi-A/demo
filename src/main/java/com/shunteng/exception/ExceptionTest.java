package com.shunteng.exception;

import sun.security.krb5.internal.crypto.EType;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2020/12/9 11:03
 */
public class ExceptionTest {

    public int fun1() {
        int i;
        try {
            i = 1;
            String str = "asdfa";
            Long.parseLong(str);
        } catch (Exception e) {
            i = 2;
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) {
       String str="";
        long l = Long.parseLong(str);
        System.out.println(l);
    }
}
