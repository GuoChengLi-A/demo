package com.shunteng.test02;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/28 下午2:57
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("66.6666");
        BigDecimal divide = bigDecimal.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);

        BigDecimal subtract = bigDecimal.subtract(new BigDecimal("6.6666"));
        System.out.println(subtract);

        BigDecimal multiply = bigDecimal.multiply(new BigDecimal("10"), MathContext.UNLIMITED);
        System.out.println(multiply);
    }
}