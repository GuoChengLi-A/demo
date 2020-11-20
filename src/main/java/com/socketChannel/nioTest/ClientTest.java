package com.socketChannel.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/16 下午2:09
 */
public class ClientTest {

    public static void main(String[] args) {

        try {
            SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

            FileChannel inChannel = FileChannel.open(Paths.get("/home/gcl/桌面/go2.png"), StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) != -1) {
                buf.flip();

                clientChannel.write(buf);

                buf.compact();
            }

            clientChannel.shutdownOutput();

            int len = 0;
            while ((len = clientChannel.read(buf)) > 0) {
                buf.flip();

                System.out.println(new String(buf.array(), 0, len));

                buf.compact();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}