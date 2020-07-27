package com.shunteng.jvm;

/**
 * @Description 堆栈溢出异常
 * @Author GCL
 * @Date 2020/7/15 下午4:24
 */
public class StackOverflowErrorTest {

    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverflowErrorTest test = new StackOverflowErrorTest();
        try{
            test.stackLeak();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}