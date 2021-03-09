package com.szy.service.handler;

import com.szy.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {

    //目标对象
    private Object target;//SomeServiceImpl类

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用执行这个invoke
        System.out.println("执行invoke方法");
        System.out.println("Method名称："+method.getName());
        String methodName=method.getName();
        Object res=null;
        if ("doSome".equals(methodName)){
            ServiceTools.doLog();
            //执行目标类的方法，通过Method类实现
            res=method.invoke(target,args);//SomeServiceImpl的doSome(),doOther（）
            ServiceTools.doTrans();
        }else {
            res=method.invoke(target,args);
        }

        //目标方法执行结果
        return res;
    }
}
