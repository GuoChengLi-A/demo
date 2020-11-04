package com.shunteng.test03;

import java.util.Objects;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 下午2:22
 */
public class StudentTest {
    Student stu1;

    public static void main(String[] args) {
        Student stu1 = new Student("tom",22);
        Student stu2 = new Student("tom",22);
        Student student = Objects.requireNonNull(stu1);
        System.out.println(stu1.equals(stu2));
        boolean b = Objects.deepEquals(stu1, stu2);
        System.out.println(b);
        System.out.println(student);
    }
}