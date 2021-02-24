package bean.jvm;

import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/22 10:15
 */
public class GCTest {

    private static void gcTest1() {
        int[] ar = new int[6 * 1024 * 1024];//6M
        ar = null;
        System.gc();
    }

    private static void gcTest2() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    public static void main(String[] args) {
        gcTest2();

        int a = 1;
        int b = 2;
        int c = 0;

        c = a;
        a = b;
        b = c;

        System.out.println("a:" + a);
    }
}
