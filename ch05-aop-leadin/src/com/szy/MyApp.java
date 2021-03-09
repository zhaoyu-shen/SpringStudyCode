package com.szy;

import com.szy.service.SomeService;
import com.szy.service.handler.MyIncationHandler;
import com.szy.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
        //����doSome,doOhter����
//        SomeService service=new SomeServiceImpl();
//        service.doSome();
//        System.out.println("===============");
//        service.doOther();

        //ʹ��jdk��Proxy�����������
        //����Ŀ�����
        SomeService target=new SomeServiceImpl();

        //����InvocationHandler����
        InvocationHandler handler=new MyIncationHandler(target);

        //ʹ��Proxy��������
        /*
        * ����1��Ŀ������������
        * ����2��Ŀ����ʵ�ֵĽӿ�
        * ����3��InvocationHandler
        * */
        SomeService proxy= (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        //ͨ������ִ�з����������handler�е�invoke����
        proxy.doOther();
        System.out.println("===================");
        proxy.doSome();
    }
}
