package com.szy;

import com.szy.service.SomeService;
import com.szy.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test01(){
        SomeService service=new SomeServiceImpl();
        service.doSome();
    }

    /*
    * spring默认创建对象的时间是：创建spring容器时，会默认创建所有对象
    * spring创建对象，默认调用无参数构造方法
    * */
    @Test
    public void test02(){
        //使用spring容器创建的对象
        //指定spring配置文件的名称
        String config="beans.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        //ApplicationContext就是spring容器，通过容器来获取对象
        //classpathXmlApplicationContext表示从类路径加载spring的配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);

        //从容器中获取某个对象，你要调用对象的方法
        //getBean("配置文件中bean的id值")
        SomeService service=(SomeService)ac.getBean("someService");

        //使用spring创建好的对象
        service.doSome();
    }

    /*
    * 获取spring容器中java对象的信息
    * */
    @Test
    public void test03(){
        String conf="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
        //使用spring提供的方法，获取容器中定义的对象的数量
        int nums=ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象的数量："+nums);

        //容器中每个定义的对象的名称
        String names[]=ac.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }
    }


    //获取一个非自定义的类对象
    @Test
    public void test04(){
        String conf="beans.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
        //使用getBean();
        Date my=(Date) ac.getBean("mydate");
        System.out.println("Date"+my);
    }
}
