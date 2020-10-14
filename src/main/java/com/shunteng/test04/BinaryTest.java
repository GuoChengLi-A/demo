package com.shunteng.test04;

import java.io.*;
import java.net.URLConnection;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/14 下午5:42
 */
public class BinaryTest {

    private static String getSuffix(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;//将二进制补码按位与运算之后并赋值给int类型的变量v
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static String getFile(String path) throws Exception {
        File file = new File(path);
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        return URLConnection.guessContentTypeFromStream(is);
    }
    public static void main(String[] args) {
        /*File file = new File("/home/gcl/桌面/go2.png");
        InputStream fileIn;
        try{

            fileIn=new FileInputStream(file);

            byte[] data = new byte[5];
            fileIn.read(data,0, 5);
            String suffix = getSuffix(data);
            System.out.println(suffix);

       }catch (Exception e){
           e.printStackTrace();
       }*/
        try{
            String file = getFile("/home/gcl/桌面/go2.png");
            System.out.println(file);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}