package org.example;

import org.example.ba02.SomeService;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {

    @Test
    public void tst01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy= (SomeService) ctx.getBean("someService");

        //通过代理对象执行方法，实现目标方法执行，增强了功能
        Student student =proxy.doOther2("gjgjg",21);
        System.out.println("str===="+student);
    }
}
