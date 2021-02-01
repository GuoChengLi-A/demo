package com.io;

import java.io.*;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/20 14:27
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {
        insert("upload.txt", 0, "汇总行\r\n");
    }


    static void insert(String filename, int pos, String insertContent) throws IOException {//pos是插入的位置
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            FileOutputStream tmpOut = new FileOutputStream(tmp);
            FileInputStream tmpIn = new FileInputStream(tmp);
            raf.seek(pos);//首先的话是0
            byte[] buf = new byte[64];
            int hasRead = 0;
            while ((hasRead = raf.read(buf)) > 0) {
                //把原有内容读入临时文件
                tmpOut.write(buf, 0, hasRead);

            }
            raf.seek(pos);
            raf.write(insertContent.getBytes());
            //追加临时文件的内容
            while ((hasRead = tmpIn.read(buf)) > 0) {
                raf.write(buf, 0, hasRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
