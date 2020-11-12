package com.shunteng.test05;

import sun.security.action.GetPropertyAction;

import java.security.AccessController;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/10 上午10:04
 */
public class OsNameTest {

    public static void main(String[] args) {

        String var0 = (String) AccessController.doPrivileged(new GetPropertyAction("os.name"));

        System.out.println(var0);
//        return (SelectorProvider)(var0.equals("Linux") ? createProvider("sun.nio.ch.EPollSelectorProvider") : new PollSelectorProvider());

    }
}