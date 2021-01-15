package com.shunteng.test06.Dip;

import java.util.HashMap;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/7 10:02
 */
public abstract class Animal {
    private String name;
    private boolean canEat;

    public abstract HashMap<String, Object> call(HashMap<String, Object> params);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanEat() {
        return canEat;
    }

    public void setCanEat(boolean canEat) {
        this.canEat = canEat;
    }
}
