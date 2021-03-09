package com.szy.ba05;

public class Student {

    private String name;
    private int age;

    //声明一个引用类型
    private School school;


    public Student() {
        //System.out.println("spring会调用类的无参构造函数创建对象");
    }

    public void setSchool(School school) {
        System.out.println("setSchool="+school);
        this.school = school;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //需要set方法
    //Bean property 'name' is not writable or has an invalid setter method.
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
