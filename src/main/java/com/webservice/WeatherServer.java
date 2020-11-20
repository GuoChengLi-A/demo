package com.webservice;

import javax.xml.ws.Endpoint;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/11/12 下午2:06
 */
public class WeatherServer {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:12345/weather",new IWeatherImpl());
    }
}