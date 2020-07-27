package com.shunteng.test01;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/6/9 下午5:45
 */
public class NIOTest {

    private static void IOMethod(FileInputStream fileInputStream) {
        InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        try {
            int read = 0;
            while ((read = bufferedInputStream.read(bytes)) != -1) {
                for (int i = 0; i < read; i++) {
                    System.out.println((char) bytes[i]);
                }
                read = bufferedInputStream.read(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void NIOMethod(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int read = channel.read(buf);//read into buffer
            System.out.println(read);
            while ((read != -1)) {
                buf.flip();//transfor read to write
                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }
                buf.compact();//clear buffer(only clear already read)
                read = channel.read(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*try {
            IOMethod(new FileInputStream("src/io.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        NIOMethod(new File("src/io.txt"));
    }

}

class TraditionalIO {

}