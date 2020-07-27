package com.shunteng.test01;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/6/23 下午5:16
 */
public class SHA256Test {

    private static byte[] SHA256Encode(String source) {
        String algorithm = "SHA-256";
        MessageDigest instance = null;
        try {
            instance = MessageDigest.getInstance(algorithm);
            instance.update(source.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return instance.digest();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] str = SHA256Encode("this is a test file");
        StringBuffer buffer = new StringBuffer();
        for (int j = 0; j < str.length; j++) {
            String s = Integer.toHexString(str[j] & 0xFF);
            if (s.length() == 1) {
                buffer.append("0");
            }
            buffer.append(s);
        }
        System.out.println(buffer.toString());
        System.out.println(buffer.toString().toUpperCase());
    }
}
