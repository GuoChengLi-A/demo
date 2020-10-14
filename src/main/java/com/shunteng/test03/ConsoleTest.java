package com.shunteng.test03;

import java.io.Console;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 下午3:13
 */
public class ConsoleTest {

    public static void main(String[] args) {
        /*Console console = System.console();

        if (console != null) {
            String s = console.readLine("UserName:");
            char[] pwd = console.readPassword("pwd:");

            System.out.println("userName:"+s);
            System.out.println("pwd:"+String.valueOf(pwd));
        }*/
        Console cons = System.console();
        String username = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("PassWord: ");
        System.out.println("User name: " + username);
        System.out.println("PassWord: " + String.valueOf(passwd));
    }
}