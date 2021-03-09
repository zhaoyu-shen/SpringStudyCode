package com.szy.ba01;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("spring会调用类的无参构造函数创建对象");
    }

    public void setEmail(String email){
        System.out.println("setEmail="+email);
    }

    public void setAge(int age) {
        System.out.println("setName:"+name);
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
        System.out.println("setAge:"+age);
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
