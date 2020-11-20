package com.socketChannel.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/17 上午10:01
 */
public class NioServerTest {

    public static void main(String[] args) {
        String path = "/home/gcl/桌面/go3.png";
        try {
            Selector selector = Selector.open();

            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress("127.0.0.1", 9999));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

//             key=null;
            while (selector.select() > 0) {//获取已就绪的key  调用select()会阻塞直到有数据连接或抛出异常
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel client = serverChannel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        FileChannel outChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                        while (client.read(buf) > 0) {
                            buf.flip();
                            outChannel.write(buf);
                            buf.compact();
                        }
                        ByteBuffer writeBuf = ByteBuffer.allocate(1024);
                        writeBuf.put("img is success".getBytes());
                        writeBuf.flip();
                        client.write(writeBuf);
                        writeBuf.compact();
                    }
                    iterator.remove();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}