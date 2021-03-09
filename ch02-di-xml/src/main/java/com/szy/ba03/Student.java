package com.szy.ba03;

public class Student {

    private String name;
    private int age;

    //声明一个引用类型
    private School school;


    public Student() {
        System.out.println("spring会调用类的无参构造函数创建对象");
    }

    /*
    * 创建有参构造方法
    * */
    public Student(String myname,int myage,School mySchool){
        System.out.println("===Student有参构造方法===");
        this.name=myname;
        this.age=myage;
        this.school=mySchool;
    }


    public void setSchool(School school) {
        this.school = school;
    }

    public void setAge(int age) {
        this.age = age;
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
