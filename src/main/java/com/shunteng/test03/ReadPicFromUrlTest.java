package com.shunteng.test03;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/9/16 下午3:14
 */
public class ReadPicFromUrlTest {
    public File saveToFile(String destUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[1024];
        int size = 0;
        File file =null;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            file = new File("test.png");
            fos = new FileOutputStream(file);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
        return file;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ReadPicFromUrlTest dw = new ReadPicFromUrlTest();
        dw.saveToFile("https://img3.912688.com/watermark-logo.png");
    }

}