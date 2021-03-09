package com.szy;

import com.szy.domain.SysUser;
import com.szy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service= (UserService) ctx.getBean("userService");

        SysUser user=new SysUser();
        user.setAge(20);
        user.setName("lisi");
        service.addUser(user);
    }
}
