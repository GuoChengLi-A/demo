package com.shunteng.test01;


import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/3 下午6:35
 */
public class Md5WithSoltTest {

    /**
     * @Description: 将str转byte[]
     */
    private static byte[] convertToByte(String str) {
        Charset charset = Charset.forName("UTF-8");
        char[] chars = str.toCharArray();
        CharBuffer buffer = CharBuffer.allocate(chars.length);
        buffer.put(chars);
        buffer.flip();
        ByteBuffer byteBuffer = charset.encode(buffer);
        int len = byteBuffer.limit() - byteBuffer.position();
        byte[] bytes = new byte[len];
        if(!byteBuffer.isReadOnly()){
            byteBuffer.get(bytes);
        }
        return bytes;
    }

    /**
     * @Description: byte[]转ascii
     */
    public static String asciiToString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int i1 = Integer.parseInt(bytes[i] + "");
            System.out.println(i1);
//            stringBuilder.append((char) );
        }
        return stringBuilder.toString();
    }

    //前台密码转为ascii码，数据库盐转ascii，md加盐计算
    public static void main(String[] args) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String salt = "b7789b143a70452b90f4dd412e7cb7e2";
        byte[] saltBytes = convertToByte(salt);
        md5.update(saltBytes);
        String password = "gcl123";
        byte[] passwordBytes = convertToByte(password);
        byte[] digest = md5.digest(passwordBytes);
        System.out.println(asciiToString(digest));
    }
}