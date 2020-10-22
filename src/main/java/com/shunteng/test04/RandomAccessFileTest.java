package com.shunteng.test04;

import java.io.RandomAccessFile;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/19 下午5:05
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {
        RandomAccessFile randomAccessFile=null;
        try{
            randomAccessFile=new RandomAccessFile("/home/gcl/桌面/io.txt","rw");
//            randomAccessFile.setLength(20);

            randomAccessFile.seek(randomAccessFile.length());

            randomAccessFile.write("last".getBytes());

        }catch (Exception e){

        }
    }
}