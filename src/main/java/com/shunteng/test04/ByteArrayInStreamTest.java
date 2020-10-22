package com.shunteng.test04;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/20 上午10:31
 */
public class ByteArrayInStreamTest {

    private static void println(byte...bs){
        StringBuffer strBuf = new StringBuffer();
        for (byte d : bs) {
            strBuf.append((char)d);
        }

        System.out.println(strBuf);
    }

    public static void main(String[] args) {
        byte[] buf="helloworld".getBytes();
        ByteArrayInputStream byteArrInStream = new ByteArrayInputStream(buf, 0, buf.length);

        byte[] data = new byte[buf.length];
        byteArrInStream.read(data,0,data.length);


        ByteArrayOutputStream byteArrOutStream = new ByteArrayOutputStream(buf.length);
        byteArrOutStream.write(data,0,4);
        System.out.println(byteArrOutStream.size()+"#"+byteArrOutStream.toString());

        byteArrOutStream.reset();//byteArrOutStream重置缓存区
        System.out.println(byteArrOutStream.size()+"#"+byteArrOutStream.toString());

        byteArrOutStream.write(data,0,3);
        System.out.println(byteArrOutStream.size()+"#"+byteArrOutStream.toString());
       /* byte[] data2 = new byte[buf.length];
        FileOutputStream fielOut=null;*/
        /*try{
            fielOut = new FileOutputStream("/home/gcl/桌面/io");
            byteArrOutStream.writeTo(fielOut);//写到outStream

            fielOut.write(data2,0,data2.length);//outStream写到file中

            byteArrOutStream.reset();//byteArrOutStream重置缓存区
            byteArrOutStream.write(data,0,3);
            println(data);
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }
}