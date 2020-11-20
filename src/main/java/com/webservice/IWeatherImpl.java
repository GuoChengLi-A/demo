package com.webservice;

import javax.jws.WebService;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/12 下午2:05
 */
@WebService
public class IWeatherImpl implements IWeather {
    @Override
    public String query(String cityName) {
        System.out.println("城市名：" + cityName);
        String weather = "暴雨";
        return weather;
    }
}