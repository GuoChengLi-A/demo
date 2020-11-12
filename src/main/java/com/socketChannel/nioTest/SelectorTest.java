package com.socketChannel.nioTest;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/10 上午11:07
 */
public class SelectorTest {

    public static void main(String[] args) {
        try {

            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            ServerSocket socket = serverChannel.socket();
            socket.bind(new InetSocketAddress(9999));
            serverChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                //准备就绪的channel
                int ready = selector.select();
                System.out.println("channel准备就绪个数：" + ready);

                if (ready > 0) {
                    Iterator<SelectionKey> keysIter = selector.selectedKeys().iterator();
                    SelectionKey next;
                    while (keysIter.hasNext()) {
                        next = keysIter.next();

                        if (next.isAcceptable()) {
                            keysIter.remove();

                            ServerSocketChannel serverChannel1 = (ServerSocketChannel) next.channel();
                            //接受socket
                            //accept()方法会一直阻塞到有新连接到达
                            SocketChannel socketChannel = serverChannel1.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);

                        }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fun(){
        try {
            SocketChannel open = SocketChannel.open();
            /*InetAddress.getByName(hostname);
            open.connect(new InetSocketAddress("",9999));
            open.h*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}