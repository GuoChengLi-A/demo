package com.shunteng.test02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 多线程io与断点续传
 * @Author GCL
 * @Date 2020/7/22 下午7:43
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(new File("/home/gcl/桌面/back_view"));
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {//类似管道，只能进不能退
                final String finalLine = line;//final修饰引用数据类型时，只保证引用地址不变，对象可以更改
                executorService.execute(() -> {
                    System.out.println(finalLine);//线程调用外部变量为什么需要final
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程等待：" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            Thread.sleep(1000);//主线程处于阻塞状态
            System.out.println("主线程等待状态");
            for (int i = 0; i < 10; i++) {
                System.out.println("主线程执行了" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                executorService.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}