package com.szy;

import com.szy.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {




    @Test
    public void test01(){
        //加载主配置文件
        String config= "ba06/total.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent= (Student) ac.getBean("myStudent");
        System.out.println("student对象="+myStudent);

    }

}
