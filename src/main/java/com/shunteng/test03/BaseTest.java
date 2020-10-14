package com.shunteng.test03;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 上午11:02
 */
public class BaseTest {

    /*a=b;如果a,b都是基本数据类型，那么修改b，不会影响a的值
    如果a,b都是引用数据类型，那么修改b，会影响a的值
    */
    int modCount=190;
    int expectedModCount=modCount;

    public static void main(String[] args) {
        //基本数据类型
        BaseTest noTest = new BaseTest();

        System.out.println(noTest.expectedModCount);

        noTest.modCount++;

        System.out.println(noTest.expectedModCount);
    }
}