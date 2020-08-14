package com.shunteng.test03;

/**
 * @Description 多态初始化测试
 * @Author GCL
 * @Date 2020/8/10 上午9:30
 */
public class PolymorphismTest {

    public static void main(String[] args) {
//        String name=new String("小花");//复制栈顶的值，再次压栈
//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//        Arrays.stream(stackTrace).forEach(System.out::println);
        Integer i = null;
        System.out.println(i == 0);
    }


}

class Parent {

    private String parentName;

    public Parent(String parentName) {
        this.parentName = parentName;
    }

    public Parent() {
    }

    public void run() {
        System.out.println("parent:" + parentName);
    }

    public void method(Integer i) {

    }

    public void method(int name) {

    }
}

class Children extends Parent {

    public Children(String parentName) {
        super(parentName);
    }

    @Override
    public void run() {
        super.run();

    }
}