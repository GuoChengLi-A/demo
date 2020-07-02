package com.shunteng.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/6/30 下午3:29
 */
public class CglibDynaProxyTest {
    public static void main(String[] args) throws Exception {
        Star star = new Star();
        MethodInterceptor methodInterceptor = new MethodInterceptorImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(star.getClass());
        enhancer.setCallback(methodInterceptor);
        ActionService proxy = (ActionService) enhancer.create();
        /*Method getMoney = proxy.getClass().getMethod("getMoney", null);
        getMoney.setAccessible(true);
        getMoney.invoke(proxy, null);*/
        proxy.sing();
        Arrays.stream(proxy.getClass().getMethods()).forEach(System.out::println);
    }
}

class MethodInterceptorImpl implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        getMoney();
        Object invoke = methodProxy.invokeSuper(o, objects);
        writeReceipt();
        return invoke;
    }

    private void getMoney() {
        System.out.println("get money");
    }

    private void writeReceipt() {
        System.out.println("write receipt");
    }
}