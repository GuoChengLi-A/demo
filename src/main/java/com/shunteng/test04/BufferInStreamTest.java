package com.shunteng.test04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/15 上午10:17
 */
public class BufferInStreamTest {

    private static String transChar(byte[] datas){
        StringBuffer strBuf = new StringBuffer();
        for (byte data : datas) {
            strBuf.append((char)data);
        }
        return strBuf.toString();
    }

    public static void main(String[] args) {
        InputStream inStream;
        BufferedInputStream bufInStream;
        try{
            inStream=new FileInputStream("/home/gcl/桌面/io");
            bufInStream=new BufferedInputStream(inStream,10);
            byte[] datas = new byte[6];

            bufInStream.read(datas,0,datas.length);
            //count=10 pos=6 markpos=-1 marklimit=0
            System.out.println(transChar(datas));

            bufInStream.mark(2);
            //count=10 pos=6 markpos=6 marklimit=2

            bufInStream.read(datas,0,datas.length);
            //read1 第一次:count=10 pos=10 markpos=6 marklimit=2
            //read1 第二次:count=10 pos=4 markpos=6 marklimit=2
            System.out.println(transChar(datas));

            bufInStream.reset();
            //count=10 pos=6 markpos=6 marklimit=2
            //假设再次调用read方法
            bufInStream.read(datas,0,datas.length);
            System.out.println(transChar(datas));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}