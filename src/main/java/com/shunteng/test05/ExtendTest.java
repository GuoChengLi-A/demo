package com.shunteng.test05;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/13 上午9:58
 */
public class ExtendTest {
    public static void main(String[] args) {
        A a = new B();
        a.fun1("");
        //80w×27=
    }
}

class A{
    final void fun1(){
        System.out.println("this is A method");
    }

    void fun1(String name){
        System.out.println("this is A 重载方法");
    }
}

class B extends A{
    /*@Override
    void fun1(){
        System.out.println("this is B method");

    }*/
}

class C{
    void fun1(){

    }

    void fun2(){
        fun1();

    }

}