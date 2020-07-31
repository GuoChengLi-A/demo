package com.shunteng.test02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/28 下午4:02
 */
public class Foo {
    static boolean boolValue;

    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        User user = new User();
        System.out.println(user.getSex());
        Field sex = user.getClass().getDeclaredField("sex");
        unsafe.putByte(user,unsafe.objectFieldOffset(sex), (byte) 2);//false !=0   true ==1
        System.out.println(user.getSex());
    }
}


class User {
    private boolean sex;//default false

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}