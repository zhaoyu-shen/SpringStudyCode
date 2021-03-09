package com.szy;

import com.szy.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest02 {




    @Test
    public void test01(){
        System.out.println("======test01=====");
        String config="ba02/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent= (Student) ac.getBean("myStudent");
        System.out.println("student对象="+myStudent);

    }

    @Test
    public void test02(){
        String config="ba02/applicationContext.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext(config);
    }


}
