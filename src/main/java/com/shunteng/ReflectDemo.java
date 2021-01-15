package com.shunteng;

import java.lang.reflect.Field;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/4 10:19
 */
public class ReflectDemo {
    //setAccic
    public static void main(String[] args) throws IllegalAccessException {
        Demo demo = new Demo("ming", 24);

        System.out.println("field：");
        Field[] fields = demo.getClass().getFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ":" + field.get(demo));

        }

        System.out.println("declaredField:");
        Field[] declaredFields = demo.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //setAccessible的方法效果？
            //设置为true，省略java的安全检查，提高性能
//            declaredField.setAccessible(true);
            System.out.println(declaredField.getName() + ":" + declaredField.get(demo));
        }
    }
}
