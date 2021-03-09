package org.example.ba02;

public class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("spring会调用类的无参构造函数创建对象");
    }

    public void setAge(int age) {
        System.out.println("setName:"+age);
        this.age = age;
    }

    public void setName(String name) {
        System.out.println("setAge:"+name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
