package com.shunteng.test05;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/3 下午2:55
 */
public class UnsafeTest {
    static int number = 5;
    String str = "HelloWorld!";

    private static Unsafe getUnsafeInstance() {
        Unsafe unsafe = null;
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return unsafe;
    }

    public static void main(String[] args) throws Exception {
        UnsafeTest unsafeTest = new UnsafeTest();
        Unsafe unsafe = getUnsafeInstance();
       /* long number = unsafe.staticFieldOffset(UnsafeTest.class.getDeclaredField("number"));
        System.out.println(number);

        long str = unsafe.objectFieldOffset(unsafeTest.getClass().getDeclaredField("str"));
        System.out.println(str);


        unsafe.putInt(UnsafeTest.class, number, 4);
        System.out.println(UnsafeTest.number);

        unsafe.putObject(unsafeTest, str, "name");
        System.out.println(unsafeTest.str);
*/
        Object o = new Object();
        long address = unsafe.allocateMemory(20);
        unsafe.putObject(Object.class, address, new Object());
        Object o2 = unsafe.getObject(Object.class, address);
        System.out.println(o2);
        unsafe.freeMemory(address);

        Object o3 = unsafe.getObject(Object.class, address);
        System.out.println(o3);
    }
}