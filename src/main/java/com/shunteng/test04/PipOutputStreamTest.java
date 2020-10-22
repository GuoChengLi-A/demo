package com.shunteng.test04;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/20 下午3:25
 */
public class PipOutputStreamTest {

    public static void main(String[] args) {
        PipedOutputStream pipOut = new PipedOutputStream();
        PipedInputStream pipIn=null;
        try {
            pipIn = new PipedInputStream(pipOut);

            byte[] data = new byte[1000];//需要调试receive
//            pipOut.write(data,);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}