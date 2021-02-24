package bean.di;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/20 14:53
 */
public class OverridingTest {

    static class A {
        protected void method() {
        }

        ;

        private void method2() {
        }

        ;

        public void method3() {
        }

        ;

        void method4() {
        }

        ;
    }

    static class B extends A {
        @Override
        protected void method() {


        }

        @Override
        public void method3() {


        }

        @Override
        void method4() {

        }
    }
}
