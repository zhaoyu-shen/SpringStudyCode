package org.example.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
     * 后置通知定义方法，方法是实现切面功能的
     * 方法的定义要求：
     * 1.公共方法public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法有参数
     * */

    /*
     * @AfterReturning:后置通知
     *   属性：1.value 切入点表达式
     *        2.returning 自定义的变量，表示目标方法是由返回值的。
     *          自定义变量名必须和通知方法的形参名一样。
     *   特点：
     *       1.在目标方法之后执行
     *       2.能够获取到目标方法的返回值，可以根据这个返回值做不同的处理
     *          Object res=doOther
     *       3.可以修改这个返回值
     *
     *  后置通知的执行
     *      Object res=doOther();
     *      myAfterReturning(res);
     *      System.out.println("res="+res);
     * */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))"
            , returning = "res")
    public void myAfterReturning(Object res) {
        //Object res:目标方法执行后的返回值，根据返回值做切面功能处理
        System.out.println("后置通知,获取的返回值是："+res);
        if (res.equals("szyNB")){

        }else{

        }

        //修改目标方法的返回值，看一下是否会改变结果
        if (res!=null){
            res="Hello SZY";
        }
    }


    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther2(..))"
            , returning = "res")
    public void myAfterReturning2(JoinPoint jp, Object res) {
        //Object res:目标方法执行后的返回值，根据返回值做切面功能处理

        System.out.println("后置通知，目标方法的定义:"+jp.getSignature());
        System.out.println("后置通知,获取的返回值是："+res);

        //修改目标方法的返回值，看一下是否会改变结果
        if (res!=null){
            Student student=new Student();
            student.setName("szy");
            student.setAge(22);
            res=student;
        }
    }


}
