package org.example.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/*
 * @Aspect:是Aspectj框架中的注解
 *   作用：表示当前类是切面类
 *   切面类：使用来给业务类增加功能的类，在这个类中有切面的功能代码
 *   位置：在定义上面
 * */
@Aspect
public class MyAspect {

   /*
   * 最终通知方法的定义格式
   *    1.public
   *    2.没有返回值
   *    3.方法名称自定义
   *    4.没有参数，如果有就是JoinPoint
   *
   * */
    /*
    * @After:最终通知
    *   属性：value 切入点表达式
    *   位置：在方法的上面
    *
    * 特点：
    *   1.总是会执行
    *   2.在目标方法之后执行
    *
    * try{
    *   SomeServiceImpl.doThird(..);
    *   }catch(Exception e){
    *
    *   }finally{
    *       myAfter();
    *   }
    * */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
   public void myAfter(){
        System.out.println("执行最终通知，总是会被执行");
        //一般用来做资源清除工作的。
   }

}
