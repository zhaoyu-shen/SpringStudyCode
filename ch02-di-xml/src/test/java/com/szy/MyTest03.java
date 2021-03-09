package com.szy;

import com.szy.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.lang.reflect.Field;

public class MyTest03 {




    @Test
    public void test01(){
        System.out.println("======test01=====");
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent= (Student) ac.getBean("myStudent3");
        System.out.println("student对象="+myStudent);

        File myFile= (File) ac.getBean("myfile");
        System.out.println(myFile.getName());
    }

}
