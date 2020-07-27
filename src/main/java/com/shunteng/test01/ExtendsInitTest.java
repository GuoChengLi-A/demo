package com.shunteng.test01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/18 上午10:40
 */
public class ExtendsInitTest {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/application.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            properties.put("sex","male");
            fileOutputStream = new FileOutputStream(new File("src/main/resources/application.properties"));
            properties.store(fileOutputStream,"updata sex=male");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Fruit1 {

    private static int count = 10;

    public Fruit1() {
        System.out.println("我是水果");
    }

    static {
        System.out.println("我还是水果");
        System.out.println(count);
    }
}

class Apple extends Fruit1 {

    private static int count = 12;

    static {
        System.out.println("我还是苹果");
        System.out.println(count);
    }

    public Apple() {
        System.out.println("我是苹果");
    }
}