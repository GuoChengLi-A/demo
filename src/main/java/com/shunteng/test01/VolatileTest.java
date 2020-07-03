package com.shunteng.test01;

/**
 * @Description 测试volatile不具有原子性
 * @Author GCL
 * @Date 2020/6/10 下午2:35
 */
public class VolatileTest {
    public volatile int num = 0;

    private void increase() {
        num++;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                for (int j = 0; j < 1000; j++) {
//                    volatileTest.increase();
                    volatileTest.num++;
                }
            };
            new Thread(runnable).start();
        }
        System.out.println(volatileTest.num);
    }
}