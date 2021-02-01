package com.shunteng.test06;

import org.springframework.util.Assert;

/**
 * @Description: 断言测试
 * @Author: GCL
 * @Date: 2021/1/18 16:09
 */
public class AssertTest {

    public static void main(String[] args) {
        String paths = null;
        Assert.notNull(paths, "Path array must not be null");


    }
}
