package com.shunteng.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/4 下午3:02
 */
public class BufferTest {


    public static void main(String[] args) {
        RandomAccessFile aFile = null;
        try {//helloworld
            aFile = new RandomAccessFile("/home/gcl/桌面/io.txt", "rw");
            ByteBuffer buf = ByteBuffer.allocate(3);
            ByteBuffer buf2 = ByteBuffer.allocate(2);
            ByteBuffer[] bufArr = {buf, buf2};
            FileChannel channel = aFile.getChannel();
            long read = channel.read(bufArr);

            while (read != -1) {
                System.out.println("写模式下空余位置:" + (buf.limit() - buf.position()));
                buf.flip();
                System.out.println("读模式下空余位置:" + (buf.limit() - buf.position()));
                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }
                buf.compact();


                buf2.flip();
                while (buf2.hasRemaining()) {
                    System.out.println((char) buf2.get());
                }
                buf2.compact();

                read = channel.read(bufArr);

            }
            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}