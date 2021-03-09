package com.szy;

import com.szy.service.SomeService;
import com.szy.service.handler.MyIncationHandler;
import com.szy.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
        //调用doSome,doOhter方法
//        SomeService service=new SomeServiceImpl();
//        service.doSome();
//        System.out.println("===============");
//        service.doOther();

        //使用jdk的Proxy创建代理对象
        //创建目标对象
        SomeService target=new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler handler=new MyIncationHandler(target);

        //使用Proxy创建代理
        /*
        * 参数1：目标类的类加载器
        * 参数2：目标类实现的接口
        * 参数3：InvocationHandler
        * */
        SomeService proxy= (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        //通过代理执行方法，会调用handler中的invoke（）
        proxy.doOther();
        System.out.println("===================");
        proxy.doSome();
    }
}
