package com.szy;

import com.szy.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void myTest01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //�������л�ȡservice
        BuyGoodsService service= (BuyGoodsService) ctx.getBean("buyService");

        System.out.println("service�Ǵ���"+service.getClass().getName());
        //���÷���
        service.buy(1001,100);
    }
}
