package com.shunteng.test06.Dip;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/6 17:52
 */
public class FieldBussinessService extends AbstractSohhService {

    //    @Override
    public void open(Map<String, Object> map) {
        System.out.println("实地商家服务已开通");
    }

    @Override
    public Map<String, Object> open(HashMap<String, Object> params) {

        return new HashMap<>();
    }
}
