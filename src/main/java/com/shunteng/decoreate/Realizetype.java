package com.shunteng.decoreate;

/**
 * @Description: 原型目标
 * @Author: GCL
 * @Date: 2021/1/8 16:29
 */
public class Realizetype implements Cloneable {


    public Realizetype() {
        System.out.println("对象创建成功");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //里氏替换：如果子类重写了父类的方法，那么方法的后置条件较父类更严格
        System.out.println("对象复制成功");
        return (Realizetype) super.clone();
    }
}
