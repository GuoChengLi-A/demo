package com.io;

import java.io.*;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/20 09:37
 */
public class WriteLines {
    public static void main(String[] args) throws IOException {
        String fileName = "upload.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");

        String line1 = line(1);
        randomAccessFile.write(line1.getBytes());

        String line2 = line(2);
        randomAccessFile.write(line2.getBytes());


        randomAccessFile.seek(0);
        String line0 = "123_test";
        randomAccessFile.write(line0.getBytes());

        randomAccessFile.close();

    }

    private static String line(int i) {
        StringBuffer strBuf = new StringBuffer();

        String command = "第" + i + "行";
        strBuf.append(command).append("|\r\n");

        return strBuf.toString();
    }
}
