package com.szy.ba01;

import org.springframework.stereotype.Component;


/*
* @Component:创建对象的，等同于<bean>的功能
*   属性：value就是对象的名称，也就是bean的id
*         value的值是唯一的，创建的对象在spring容器中就一个
*   位置：在类的上面
*
* spring中和@Component功能一致，创建对象的注解还有
* 1.@Repository（用在持久层类的上面）：放在dao的实现类上面
*       表示创建dao对象，dao对象是能反问数据库
*2.@Service（用在业务层类上）：放在Service的实现类上面
*       创建Service对象，Service对象就是业务处理，可以有事物等功能
* 3.@Controller（用在控制器上面）：放在控制器类的上面，创建控制器对象
*       控制器对象，能够接受用户提交的参数，显示请求的处理结果
* 以上三个注解使用语法和@Component一样。都能创建对象，但是这三个注解还有额外功能
* @Repository，@Service，@Controller是用于给项目分层的
*
*
* */
//使用value属性，指定对象名称
//@Component(value = "myStudent")
//省略value
@Component("myStudent")
//不指定对象名称，由Spring提供默认名称：类名的首字母小写
//@Component
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("===Student无参构造方法===");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
