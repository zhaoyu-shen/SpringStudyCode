package com.szy.service.handler;

import com.szy.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {

    //Ŀ�����
    private Object target;//SomeServiceImpl��

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //ͨ���������ִ�з���ʱ�������ִ�����invoke
        System.out.println("ִ��invoke����");
        System.out.println("Method���ƣ�"+method.getName());
        String methodName=method.getName();
        Object res=null;
        if ("doSome".equals(methodName)){
            ServiceTools.doLog();
            //ִ��Ŀ����ķ�����ͨ��Method��ʵ��
            res=method.invoke(target,args);//SomeServiceImpl��doSome(),doOther����
            ServiceTools.doTrans();
        }else {
            res=method.invoke(target,args);
        }

        //Ŀ�귽��ִ�н��
        return res;
    }
}
