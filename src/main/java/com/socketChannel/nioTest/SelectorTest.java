package com.socketChannel.nioTest;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/10 上午11:07
 */
public class SelectorTest {

    public static void main(String[] args) {
        try {

            ServerSocketChannel serverChannel1 = ServerSocketChannel.open();
            serverChannel1.bind(new InetSocketAddress(9999));


            Selector selector = Selector.open();
            serverChannel1.configureBlocking(false);
            System.out.println(serverChannel1.validOps());
            //第一个serverChannel注册
            serverChannel1.register(selector, SelectionKey.OP_ACCEPT);

            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.bind(new InetSocketAddress(12312));
            clientChannel.connect(new InetSocketAddress("127.0.0.1", 12312));
            clientChannel.configureBlocking(false);
            clientChannel.register(selector, SelectionKey.OP_WRITE);

            //第二个serverChannel注册
            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.configureBlocking(false);
            serverSocketChannel2.register(selector,SelectionKey.OP_ACCEPT);

            SelectorProvider provider = serverSocketChannel2.provider();
            System.out.println("provider:+++++"+provider);

            Set<SelectionKey> keys = selector.keys();
            keys.stream().forEach(System.out::println);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("+++++++++++select之前++++++++++++++++++");
            selectionKeys.stream().forEach(System.out::println);

            int select = selector.select();
            Set<SelectionKey> selectionKeys1 = selector.selectedKeys();
            System.out.println("+++++++++++select之后++++++++++++++++++");

            selectionKeys1.stream().forEach(System.out::println);
            /*while (true) {
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
                            SelectorProvider provider = serverChannel1.provider();
                            System.out.println("provider:"+provider);
                            //接受socket
                            //accept()方法会一直阻塞到有新连接到达
                            SocketChannel socketChannel = serverChannel1.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);

                        }
                    }
                }

            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fun() {
        try {
            SocketChannel open = SocketChannel.open();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}