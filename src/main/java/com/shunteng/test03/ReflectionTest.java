package com.shunteng.test03;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/8/13 上午10:38
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Class klass = Class.forName("com.shunteng.test03.Test");
        Object testInstance = klass.newInstance();
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(testInstance, i);
        }
    }
}

class Test {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }
}