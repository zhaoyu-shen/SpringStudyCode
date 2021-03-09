package com.szy.ba06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component("myStudent")
public class Student {

    @Value("张飞")
    private String name;
    private Integer age;

    /*
     * 引用类型
     *@Resource 来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *          使用的也是自动注入原理，支持byName，byType，默认byName
     * 位置：1.在属性定义的上面，无需set方法，推荐使用
     *      2.在set方法上面
     * */
    //默认是byName：先使用byName自动注入，如果byName失败，使用byType
    @Resource
    private School school;

    public Student() {
        System.out.println("===Student无参构造方法===");
    }

    //    public void setName(String name) {
//        this.name = name;
//    }
    @Value("25")
    public void setAge(Integer age) {
        System.out.println("setAge:" + age);
        this.age = age;
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
