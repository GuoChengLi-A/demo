package com.shunteng.test01;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/18 上午10:40
 */
public class ExtendsInitTest {

    public static void main(String[] args) {
        apple apple = new apple();
//        fruit fruit = new fruit();

    }
}
class fruit{

    private static int count=10;

    public fruit(){
        System.out.println("我是水果");
    }
    static {
        System.out.println("我还是水果");
        System.out.println(count);
    }
}

class apple extends fruit{

    private static int count=12;

    static{
        System.out.println("我还是苹果");
        System.out.println(count);
    }
    public apple() {
        System.out.println("我是苹果");
    }
}