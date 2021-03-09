package org.example.ba01;


//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name,Integer age) {
        //给doSome方法增加功能，在doSome执行之前，打印时间
        System.out.println("===目标方法doSome()===");
    }
}
