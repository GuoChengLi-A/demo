package com.shunteng.jvm;

import java.util.ArrayList;

/**
 * @Description 内容溢出或内存泄露测试
 * @Author GCL
 * @Date 2020/7/8 上午9:43
 */
public class OOMTest {

    static class OOMObject{

    }
    public static void main(String[] args) {
        ArrayList<OOMObject> listOOMOBject = new ArrayList<>();
        while (true) {
            listOOMOBject.add(new OOMObject());
        }
    }
}

/*class OOMObject {

}*/
