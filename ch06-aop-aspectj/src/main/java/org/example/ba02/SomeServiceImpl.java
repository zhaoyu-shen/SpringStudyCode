package org.example.ba02;


//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加功能，在doSome执行之前，打印时间
        System.out.println("===目标方法doSome()===");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("===目标方法doOther()===");
        return "szyNB";
    }

    @Override
    public Student doOther2(String name, Integer age) {
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }
}
