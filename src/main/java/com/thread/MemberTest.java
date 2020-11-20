package com.thread;

/**
 * @Description 内存测试
 * @Author GCL
 * @Date 2020/11/18 上午11:34
 */
public class MemberTest {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(()->{

            }).start();

        }

    }
}