package org.example;

import org.example.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {

    @Test
    public void tst01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //�������л�ȡĿ�����
        //com.sun.proxy.$Proxy8
        SomeService proxy= (SomeService) ctx.getBean("someService");
        System.out.println("proxy:"+proxy.getClass().getName());
        //ͨ���������ִ�з�����ʵ��Ŀ�귽��ִ�У���ǿ�˹���
        proxy.doSome("lisi",23);
    }
}
