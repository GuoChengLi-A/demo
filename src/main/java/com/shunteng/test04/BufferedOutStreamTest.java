package com.shunteng.test04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/19 上午11:15
 */
public class BufferedOutStream {

    public static void main(String[] args) {
        BufferedInputStream bufInStream=null;
        FileInputStream fileInStream=null;

        BufferedOutStream bufOutStream=null;

        try{
            fileInStream=new FileInputStream("/home/gcl/桌面/io");
           bufInStream=new BufferedInputStream(fileInStream);
        }catch (Exception e){

        }
    }
}