package com.webservice;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/12 下午2:22
 */
public class WebClient {

    public static void main(String[] args) {
        IWeatherImplService iWeatherImplService = new IWeatherImplService();

        IWeatherImpl iWeatherImpl = iWeatherImplService.getPort(IWeatherImpl.class);

        String weather = iWeatherImpl.query("北京");
        System.out.println(weather);
        String s = " (゜-゜)つロ 干杯~-bilibili";
        System.out.println(s);
        System.out.println("7c7827c9-9dc3-".length());
    }
}