package com.shunteng.test06.Dip;

/**
 * @Description: 依赖倒置原则
 * @Author: GCL
 * @Date: 2021/1/6 17:49
 */
public class DIPtest {

    public static void main(String[] args) {
        AbstractSohhService service = new FieldBussinessService();
//        service.open();
    }
}
