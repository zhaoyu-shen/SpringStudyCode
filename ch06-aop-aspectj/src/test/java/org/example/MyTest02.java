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
        //�������л�ȡĿ�����
        SomeService proxy= (SomeService) ctx.getBean("someService");

        //ͨ���������ִ�з�����ʵ��Ŀ�귽��ִ�У���ǿ�˹���
        Student student =proxy.doOther2("gjgjg",21);
        System.out.println("str===="+student);
    }
}
