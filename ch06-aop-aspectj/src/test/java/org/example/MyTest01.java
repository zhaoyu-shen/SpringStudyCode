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
        //从容器中获取目标对象
        //com.sun.proxy.$Proxy8
        SomeService proxy= (SomeService) ctx.getBean("someService");
        System.out.println("proxy:"+proxy.getClass().getName());
        //通过代理对象执行方法，实现目标方法执行，增强了功能
        proxy.doSome("lisi",23);
    }
}
