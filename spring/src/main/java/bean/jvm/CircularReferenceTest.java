package bean.jvm;

/**
 * @Description: 循环引用示例
 * @Author: GCL
 * @Date: 2021/2/22 10:40
 */
public class CircularReferenceTest {

    private A a = new A();

    static class A {
        private B b = new B();
    }

    static class B {
        private A a = new A();
    }

    public static void main(String[] args) {
        CircularReferenceTest circularReferenceTest = new CircularReferenceTest();
        A a = new A();
        B b = new B();
        a.b = b;
        b.a = a;
        circularReferenceTest.a = a;
    }
}
