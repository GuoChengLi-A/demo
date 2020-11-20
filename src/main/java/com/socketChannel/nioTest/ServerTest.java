package com.socketChannel.nioTest;

import java.io.File;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/16 下午2:14
 */
public class ServerTest {

    public static void main(String[] args) {
        ServerSocketChannel serverChannel = null;
        String path = "/home/gcl/桌面/go3.png";

        try {
            serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress("127.0.0.1", 9999));
            SocketChannel clientChannel = serverChannel.accept();

            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileChannel outChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE, StandardOpenOption.READ);

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (clientChannel.read(buf) > 0) {
                buf.flip();

                outChannel.write(buf);

                buf.compact();
            }

            buf.put("img已收到".getBytes());
            buf.flip();
            clientChannel.write(buf);
            buf.compact();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}