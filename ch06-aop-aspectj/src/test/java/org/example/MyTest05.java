package org.example;

import org.example.ba05.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {

    @Test
    public void tst01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //�������л�ȡĿ�����
        SomeService proxy= (SomeService) ctx.getBean("someService");

        //ͨ���������ִ�з�����ʵ��Ŀ�귽��ִ�У���ǿ�˹���
        proxy.doThird();
    }
}
