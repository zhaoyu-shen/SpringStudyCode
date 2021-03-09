package org.example.ba03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.ba02.Student;

import java.util.Date;

/*
 * @Aspect:是Aspectj框架中的注解
 *   作用：表示当前类是切面类
 *   切面类：使用来给业务类增加功能的类，在这个类中有切面的功能代码
 *   位置：在定义上面
 * */
@Aspect
public class MyAspect {

   /*
   * 环绕通知方法的定义格式
   *    1.public
   *    2.必须有返回值，推荐使用Object
   *    3.方法名称自定义
   *    4.方法有参数，固定的参数ProceedingJoinPoint
   * */
    /*
    * @Around环绕通知
    *   属性：value    切入点表达式
    *   位置：在方法定义上面
    *
    * 特点：
    *   1.功能最强的通知
    *   2.在目标方法的前和后都能增强功能
    *   3.控制目标方法是否被调用
    *   4.修改原来的目标方法的执行结果。影响最后的结果
    *
    * 环绕通知，等同于jdk动态代理InvocationHandler
    *
    * 参数：ProceedingJoinPoint等同于Method
    * 返回值：就是目标方法的执行结果，可以被修改
    *
    * 环绕通知：经常做事务，在目标方法之前开启事务，执行方法，方法之后提交事务
    * */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        String name="";
        //获取第一个参数
        Object args[]=pjp.getArgs();
        if (args!=null&&args.length>1){
            Object arg=    args[0];
            name= (String) arg;
        }


        //实现环绕通知
        Object result=null;

        System.out.println("环绕通知：目标方法之前输出时间："+new Date());
        //1.目标方法调用
        if ("szy".equals(name)){
            //符合条件，调用目标方法
            result=pjp.proceed();//method.invoke;Object result=doFirst();
        }
        System.out.println("环绕通知：目标方法之后输出时间："+new Date());

        // 2.在目标方法的前后加入功能

        //修改目标方法的执行结果，影响方法最后的调用介个
        if (result!=null){
            result="SZYNB";
        }

        //返回目标方法执行结果
        return result;

    }

}
