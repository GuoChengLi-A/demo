package com.socketChannel.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @Description client无问题
 * @Author GCL
 * @Date 2020/11/17 上午10:01
 */
public class NioClientTest {
    public static void main(String[] args) {
        String path = "/home/gcl/桌面/go2.png";
        try {
            Selector selector = Selector.open();
            SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            clientChannel.configureBlocking(false);//设置为非阻塞状态
            clientChannel.register(selector, SelectionKey.OP_READ);
            
            FileChannel inChannel = FileChannel.open(Paths.get(path), StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) != -1) {
                buf.flip();
                clientChannel.write(buf);
                buf.compact();
            }
            SelectionKey key = null;
//            clientChannel.finishConnect();
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();//这个channel与clientChannel有区别么？
                        ByteBuffer buf2 = ByteBuffer.allocate(1024);
                        while (client.read(buf2) > 0) {
                            buf2.flip();
                            System.out.println(new String(buf2.array(), 0, buf2.limit()));
                        }
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}