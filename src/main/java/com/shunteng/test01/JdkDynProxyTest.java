package com.shunteng.test01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/6/30 下午1:57
 */
public class JdkDynProxyTest {

    public static void main(String[] args) {
        Star star = new Star();
        ClassLoader classLoader = star.getClass().getClassLoader();
        Class<?>[] interfaces = star.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(star);
        Object jdkProxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        ActionService actionService=(ActionService)jdkProxy;
        actionService.sing();
    }
}

interface ActionService{

    void sing();

    void sleep();

}

class Star implements ActionService{
    @Override
    public void sing() {
        System.out.println("唱歌ing");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉ing");
    }

    public void privateMethod(){

    }
}

class InvocationHandlerImpl implements InvocationHandler{

    private ActionService actionService;

    public InvocationHandlerImpl(ActionService actionService) {
        this.actionService = actionService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        getMoney();
        Object invoke = method.invoke(actionService, args);
        writeReceipt();
        return invoke;
    }

    private void getMoney(){
        System.out.println("get money");
    }

    private void writeReceipt(){
        System.out.println("write receipt");
    }
}