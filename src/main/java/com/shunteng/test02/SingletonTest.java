package com.shunteng.test02;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/31 下午2:03
 */
public class SingletonTest {
    private SingletonTest() {
    }

    private static class LazyHolder {
        static final SingletonTest INSTANCE = new SingletonTest();

        static {
            System.out.println("LazyHolder.");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag) {
            return new LazyHolder[2];
        }
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Object instance = getInstance(true);
        System.out.println(instance);
        System.out.println("----");
        Object instance1 = getInstance(false);
        System.out.println(instance1);
    }
}