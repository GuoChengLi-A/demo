package com.shunteng.test04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/19 上午11:15
 */
public class BufferedOutStreamTest {

    public static void main(String[] args) {
        BufferedInputStream bufIn = null;
        FileInputStream fileIn = null;

        BufferedOutputStream bufOut = null;
        FileOutputStream fileOut = null;
        try {
            fileIn = new FileInputStream("/home/gcl/桌面/io");
            bufIn = new BufferedInputStream(fileIn);

            fileOut = new FileOutputStream("/home/gcl/桌面/io2.txt");


            bufOut = new BufferedOutputStream(fileOut);
            byte[] data = new byte[1024];
//            byte[] out = new byte[1024];
            while (bufIn.read(data, 0, data.length) != -1) {
                bufOut.write(data, 0, data.length);//write之后需要调用flush到buf中
//                bufOut.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (bufOut != null) {
                    bufOut.close();
                }
                if(fileOut!=null){
                    fileOut.close();
                }
                if (bufIn != null) {
                    bufIn.close();
                }
                if (fileIn != null) {
                    fileIn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}