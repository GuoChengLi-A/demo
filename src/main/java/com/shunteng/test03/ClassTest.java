package com.shunteng.test03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/8/11 下午5:40
 */
public class ClassTest {

    private String name;

    private void method(String name) {

    }

    /*private String method(String name) {
        return null;
    }*/

    public static void main(String[] args) throws Exception {
        try{
            String name="test";
        }catch (Exception e){
            e.printStackTrace();
        }
        Class<Parent> clazz = Parent.class;
        Parent parent = clazz.newInstance();
        ClassLoader classLoader = parent.getClass().getClassLoader();
        System.out.println(classLoader);
        System.out.println(ClassLoader.getSystemClassLoader());
        Object clazzTest = classLoader.loadClass("com.shunteng.test03.ClassTest").newInstance();

        Field[] fields = clazzTest.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);

        Method[] methods = clazzTest.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ProtectionDomain protectionDomain = clazz.getProtectionDomain();
        System.out.println(protectionDomain.getCodeSource());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(protectionDomain.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(clazzTest.getClass().getName());
       /* String bootClassPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootClassPath);*/
    }
}