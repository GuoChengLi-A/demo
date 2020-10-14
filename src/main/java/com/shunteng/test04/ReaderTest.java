package com.shunteng.test04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 下午3:27
 */
public class ReaderTest {

    public static void main(String[] args) {
        FileInputStream fileIn=null;
        InputStreamReader inStream=null;
        BufferedReader bufReader=null;
        try{
            File file = new File("/home/gcl/桌面/war");
            fileIn = new FileInputStream(file);

            System.out.println("文件描述符："+fileIn.getFD());

            inStream = new InputStreamReader(fileIn);
            bufReader = new BufferedReader(inStream);

            char[] data = new char[100];

            bufReader.read(data,50,51);
            /*while (bufReader.ready()){
                int read = bufReader.read(data, 0, data.length);//返回下一数组字节
                System.out.println((char) read);
//                System.out.println(fileIn.available());
            }*/
            while (bufReader.read(data,0,data.length)!=-1){
                System.out.println(data);
                bufReader.skip(data.length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fileIn!=null){
                    fileIn.close();
                }
                if (inStream != null) {
                    inStream.close();
                }
                if (bufReader != null) {
                    bufReader.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}