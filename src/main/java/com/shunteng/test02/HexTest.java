package com.shunteng.test02;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/28 下午3:23
 */
public class HexTest {
    public static void main(String[] args) {
        float v = Float.intBitsToFloat(0x8000000);//3.85186*(10^-34)
        System.out.println(-0.0F);
        System.out.println("-0.0F:"+v);
        System.out.println("负无穷:"+1f/-0.0F);//负无穷
        System.out.println("正无穷:"+1f/+0.0F);
        System.out.println(0x7F800001);
        float f;
        System.out.println();
    }
}