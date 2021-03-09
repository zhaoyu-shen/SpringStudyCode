package org.example;

import org.example.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {

    @Test
    public void tst01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //�������л�ȡĿ�����
        SomeServiceImpl proxy= (SomeServiceImpl) ctx.getBean("someService");


        /*
        * Ŀ����û�нӿڣ�ʹ��cglib��̬����spring��ܻ��Զ�Ӧ��cglib
        *org.example.ba07.SomeServiceImpl$$EnhancerBySpringCGLIB$$58276a1c
        *  */
        System.out.println("proxy:"+proxy.getClass().getName());
        //ͨ���������ִ�з�����ʵ��Ŀ�귽��ִ�У���ǿ�˹���
        proxy.doThird();
    }
}
