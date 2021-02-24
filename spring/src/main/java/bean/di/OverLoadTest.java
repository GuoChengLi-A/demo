package bean.di;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/20 09:53
 */
public class OverLoadTest {

    static class NestedClass {
        void method() {
        }

        protected void method2() {
        }

        private void method3() {
        }

        public void method4() {
        }
    }

    class InnerClass {
        private NestedClass cls = new NestedClass();

    }

    abstract static class AbstractClass {
        static void method() {

        }
    }

    interface IInterface {
        static void method() {
            System.out.println("只要被static修饰，那么就可以有方法题");
        }
    }

    interface IInterface2 extends IInterface {

    }

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    class Jonathan extends Apple {
    }

    class Orange extends Fruit {
    }


    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<>();
        list.add(null);
        //上界只能get

        list.get(0);

        List<? super Fruit> listApple = new ArrayList<>();
        listApple.add(new Apple());

    }


}
