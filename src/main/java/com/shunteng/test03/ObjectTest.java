package com.shunteng.test03;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/10/10 上午11:04
 */
public class ObjectTest {

    Student stu1=new Student("tom",23);
    Student stu2=stu1;
    public static void main(String[] args) {

        ObjectTest t = new ObjectTest();
        System.out.println(t.stu2);

        t.stu1.setName("pete");
        System.out.println(t.stu2);
    }
}

class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}