package com.shunteng.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/6/1 上午11:00
 */
public class ForLoopTest {

    private List<Country> list = new ArrayList<>();

    public List<Country> listCountries(int count) {
        int isDelete = ((int) (10 * Math.random())) % 2;
        for (int i = 0; i < count; i++) {
            Country country = new Country(i + "", i, i + "", isDelete);
            list.add(country);
        }
        return list;
    }

    /**
     * @Description: 普通for循环
     */
    public long normalForLoop(List<Country> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * @Description: foreach循环
     */
    public long forEachLoop(List<Country> list) {
        long start = System.currentTimeMillis();
        for (Country country : list) {

        }
        long end = System.currentTimeMillis();
        return end - start;

    }

    public void start() {
        List<Country> listCountries = listCountries(400000);
        long l = normalForLoop(listCountries);
        long l1 = forEachLoop(listCountries);
        System.out.println("普通for循环时间：" + l);
        System.out.println("foreach循环时间：" + l1);
    }

    public static void main(String[] args) {
        new ForLoopTest().start();
    }
}

class Country {
    private String name;
    private long area;
    private String updateTime;
    private int isDelete;//0：未删除 1：删除

    public Country() {
    }

    public Country(String name, long area, String updateTime, int isDelete) {
        this.name = name;
        this.area = area;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}