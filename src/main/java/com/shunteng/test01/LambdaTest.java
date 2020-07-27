package com.shunteng.test01;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LambdaTest {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("lambda实现线程")).start();
        List<Student> students = Student.listStudents();
        students.forEach(student -> System.out.println(student.toString()));
        System.out.println("~~~~~~~~~~~");
//        students.forEach((e -> e.setAge(e.getAge() + 3)));
//        students.forEach(System.out::println);
        students.stream().filter(student -> student.getAge() > 25).filter(student -> "男".equals(student.getSex())).forEach(System.out::println);
        System.out.println("~~~~~~~~~~~");
        Student max = students.stream().max(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(max.toString());
        System.out.println("~~~~~~~~~~~");
        Comparator<Integer> comparator = Integer::sum;
        students.stream().map(student -> {
            student.setAge(student.getAge() + 3);
            return student;
        }).forEach(System.out::println);
        System.out.println("~~~~~~~~~~~");
        String[] array = {"a", "b", "c"};
        for (Integer i : Lists.newArrayList(1, 2, 3)) {
            Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
        }
        System.out.println("~~~~~~~~~~~~");
        for (int b = 1; b < 4; b++) {
            int finalB = b;
            Stream.of(array).map(item -> Strings.padEnd(item, finalB, '@')).forEach(System.out::println);
        }
        System.out.println("~~~~~~~~~~~~~");
        //根据年龄大小排序
        Student[] arr = new Student[students.size()];
        Arrays.sort(students.toArray(arr), Comparator.comparingInt(Student::getAge));
        for (Student s : arr) {
            System.out.println(s.toString());
        }
        System.out.println("~~~~~~~~~");
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStream.flatMap(Collection::stream);

        System.out.println("~~~~~~~~~~~");
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }


}


class Student {

    private Integer studyId;
    private String name;
    private Integer age;
    private String sex;

    static List<Student> listStudents() {
        Student gcl = new Student(1, "gcl", 23, "男");
        Student tom = new Student(2, "tom", 25, "男");
        Student ming = new Student(1, "ming", 14, "男");
        Student wink = new Student(1, "wink", 34, "女");
        List<Student> list = new ArrayList<>();
        list.add(gcl);
        list.add(tom);
        list.add(ming);
        list.add(wink);
        return list;
    }

    public Student() {
    }

    public Student(Integer studyId, String name, Integer age, String sex) {
        this.studyId = studyId;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getStudyId() {
        return studyId;
    }

    public void setStudyId(Integer studyId) {
        this.studyId = studyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studyId=" + studyId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
