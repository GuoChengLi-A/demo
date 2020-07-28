package com.shunteng.test02;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/27 上午9:56
 */
public class HelloworldTest {
    public static void main(String[] args) {
//        int testInt=128;
        boolean flag = true;//虚拟机中为flag=1
        if (flag) {//栈顶不为0进入if(flag!=0){}
            System.out.println("Hello, Java!");
        }
        if (flag == true) {//两值相等则进入if(flag==){}
            System.out.println("Hello, JVM!");
        }
        char c='1';
        float v = Float.intBitsToFloat(0x8000000);
        System.out.println(v);
        boolean [] booleanArray=new boolean[3];
        int a=1;
        long b=a;
        double d=b;
    }
}