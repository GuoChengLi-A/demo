package com.socketChannel.nioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/16 上午10:46
 */
public class Files {

    /**
     * @Description: 文件拷贝
     */
    public static boolean copy1(String src, String dst) {
        FileInputStream in = null;
        FileOutputStream out = null;
        boolean result = true;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst);

            FileChannel inChannel = in.getChannel();
            FileChannel outChannel = out.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf) != -1) {
                buf.flip();

                outChannel.write(buf);

                buf.compact();

            }
            outChannel.close();
            inChannel.close();
        } catch (Exception e) {
            result = false;
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return result;
    }

    /** 直接缓存区
     * @param src 源文件路径
     * @param dst 目标文件路径
     */
    public static boolean copy2(String src, String dst) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        boolean result = true;
        try {
            File file = new File(dst);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                return false;
            }

            inChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get(dst), StandardOpenOption.WRITE, StandardOpenOption.READ);
            //映射到内存中
            MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            byte[] data = new byte[inMap.limit()];
            inMap.get(data);
            outMap.put(data);

            outChannel.close();
            inChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    /** 直接缓存区
     * @param src
     * @param dst
     */
    public static boolean copy3(String src, String dst) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        boolean result = true;
        try {
            File file = new File(dst);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                return false;
            }

            inChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get(dst), StandardOpenOption.WRITE, StandardOpenOption.READ);

            inChannel.transferTo(0, inChannel.size(), outChannel);

            outChannel.close();
            inChannel.close();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        copy3("/home/gcl/桌面/go2.png", "/home/gcl/桌面/go3.png");
    }
}