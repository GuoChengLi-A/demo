package com.io;

import java.io.*;
import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/1/20 10:50
 */
public class ReadLines {

    public static void main(String[] args) throws IOException {
        File separate = new File("test.txt");
        FileReader reader = new FileReader(separate);
        BufferedReader bufReader = new BufferedReader(reader);
        while (bufReader.ready()) {
            String s = bufReader.readLine();

            String[] split = s.split("\\|");
            Arrays.stream(split).forEach(System.out::print);
            System.out.println();
        }
        bufReader.close();
    }
}
