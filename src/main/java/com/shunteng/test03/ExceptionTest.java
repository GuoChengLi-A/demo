package com.shunteng.test03;

import sun.reflect.Reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/8/12 上午11:09
 */
public class ExceptionTest {

    public static void main(String[] args) {
        Class<?> callerClass = Reflection.getCallerClass();
        System.out.println(callerClass);
    }

    public static String method() {
        List<String> listStr = new ArrayList<>();
        try {
//            Integer.parseInt("helloworld");//NumberFormatException
            listStr.get(20);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            /*try{
                listStr.get(20);
            }catch (IndexOutOfBoundsException e2){
                e2.addSuppressed(e);
                e2.printStackTrace();
            }*/
            e.printStackTrace();
//            throw new IllegalArgumentException("catch block");
        } finally {
//            throw  new ArrayIndexOutOfBoundsException("finally block");
        }
        return null;
    }


}
