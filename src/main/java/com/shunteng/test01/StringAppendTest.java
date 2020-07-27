package com.shunteng.test01;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/18 上午11:05
 */
public class StringAppendTest {
    public static void main(String[] args) {
        /*String s1 = "1";
        String s2 = new String("1");
        String s3 = "1" + "2" + "3";
        String s4 = "123";
        String s5 = "1" + "3" + new String("1") + "4";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));*/
//        String str2 = new String("hello");
//        String str="hello";
//        System.out.println(str==str2);
        /*String s1 = "AB";
        String s2 = new String("AB");
        String s3 = "A";
        String s4 = "B";
        String s5 = "A" + "B";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());*/
        /*String hello = new String("hello");
        hello.intern();
        String hello2="hello";
        System.out.println(hello==hello2);*/
        /*String hello = new String("hello");
//        String hello2="hello";
        String intern = hello.intern();
        String hello2="hello";
        System.out.println(hello==hello2);
        System.out.println(hello2==intern);*/
        String str=new String("hello")+new String(" world");
        str.intern();
        String str2="hello world";
        System.out.println(str==str2);

        String str3=new String("aa")+new String("bb");
        String str4="aabb";
        str3.intern();
        System.out.println(str3==str4);

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2); //false
        /*String str="a";
        String str2="a"+str;
        str2.intern();
        String str3="aa";
        System.out.println(str2==str3);*/
    }
}
