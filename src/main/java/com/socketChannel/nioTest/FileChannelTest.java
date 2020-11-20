package com.socketChannel.nioTest;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/16 上午10:09
 */
public class FileChannelTest {

    public static void main(String[] args) {
        FileInputStream inStream;
        try {
            /*inStream = new FileInputStream("/home/gcl/桌面/io.txt");
            FileChannel inchannel = inStream.getChannel();*/
            FileChannel inchannel = FileChannel.open(Paths.get("/home/gcl/桌面/io.txt"), StandardOpenOption.READ);

            ByteBuffer byteBuf = ByteBuffer.allocate(1024);
            int read = inchannel.read(byteBuf);

            while (read != -1) {
                byteBuf.flip();

                /*for (int i = 0; i < byteBuf.limit(); i++) {
                    System.out.println((char)byteBuf.get(i));
                }*/
                while (byteBuf.hasRemaining()) {
                    System.out.println((char)byteBuf.get());
                }

                byteBuf.compact();
                read=inchannel.read(byteBuf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}