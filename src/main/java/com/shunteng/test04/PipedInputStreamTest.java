package com.shunteng.test04;

import java.io.*;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/12 下午3:29
 */
public class PipedInputStreamTest {

    synchronized void receive(byte b[], int off, int len) throws IOException {
//        writeSide = Thread.currentThread();
        int bytesToTransfer = len;
        int in = -1;
        int out = 0;
        byte[] buffer = new byte[1024];
        while (bytesToTransfer > 0) {
            if (in == out) {
//                awaitSpace();
            }
            int nextTransferAmount = 0;//表示缓冲区剩余位置
            if (out < in) { //要读取的索引值 < 要存储的索引值；循环一次 len=1024 out=1022, in=1023???什么原因导致？
                nextTransferAmount = buffer.length - in;
            } else if (in < out) {
                if (in == -1) {
                    in = out = 0;
                    nextTransferAmount = buffer.length - in;
                } else {
                    nextTransferAmount = out - in;
                }
            }

            if (nextTransferAmount > bytesToTransfer)//buffer数组剩余位置数大于要读取字节数
                nextTransferAmount = bytesToTransfer;
            assert (nextTransferAmount > 0);
            System.arraycopy(b, off, buffer, in, nextTransferAmount);
            bytesToTransfer -= nextTransferAmount;
            off += nextTransferAmount;
            in += nextTransferAmount;
            if (in >= buffer.length) {
                in = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/home/gcl/桌面/Java 源码阅读顺序");
        String str = "this is pip test";
        System.out.println(str.length());

        PipedOutputStream pipOut = new PipedOutputStream();
        PipedInputStream pipIn = new PipedInputStream(pipOut, str.length()/2);//buffer size str.length() / 2

        pipOut.write(str.getBytes(), 0, str.length());

        byte[] b = new byte[str.length() / 2];
        while (pipIn.read(b, 0, b.length) != -1) {
            pipOut.write(b,0,b.length);
            System.out.println(1);
        }

    }
}