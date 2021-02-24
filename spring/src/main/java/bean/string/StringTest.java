package bean.string;

import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/20 11:14
 */
public class StringTest {

    public static void main(String[] args) {
//        new B();

        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(1);
        arrayList.add(new B());

        System.out.println(arrayList);

    }

    static class C {
        C() {
            System.out.println("C");
        }
    }

    static class A {
        C c = new C();

        A() {
            System.out.println("A");
        }

        A(String string) {
            System.out.println(string);
        }
    }

    static class B extends A {
        B() {
            super("B");
            System.out.println("B");
        }


    }
}
