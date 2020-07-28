package com.shunteng.test02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description 日期处理类测试
 * @Author GCL
 * @Date 2020/7/28 下午2:18
 */
public class CalendarTest {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,0);
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}