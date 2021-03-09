package org.example.ba07;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * @Aspect:是Aspectj框架中的注解
 *   作用：表示当前类是切面类
 *   切面类：使用来给业务类增加功能的类，在这个类中有切面的功能代码
 *   位置：在定义上面
 * */
@Aspect
public class MyAspect {

    @After(value = "mypt()")
    public void myAfter() {
        System.out.println("执行最终通知，总是会被执行");
        //一般用来做资源清除工作的。
    }

    @Before(value = "mypt()")
    public void myBefore() {
        System.out.println("执行前置通知，在目标方法之前执行");
        //一般用来做资源清除工作的。
    }

    /*
    * @Pointcut:定义和管理切入点，如果项目中有多个重复的切入点表达式
    *           可以使用@Pointcut
    *   属性：value 切入点表达式
    *   位置：在自定义方法的上面
    *
    * 特点：
    *   但使用@Pointcut定义在一个方法的上面，此时这g方法的名称就是切入点表达式的别名。
    *   其他的通知中,value属性就可以使用这该方法名称代替切入点表达式
    * */
    @Pointcut(value ="execution(* *..SomeServiceImpl.doThird(..))" )
    private void mypt(){
        //无需代码
    }

}
