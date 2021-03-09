package org.szy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.szy.dao.StudentDao;
import org.szy.domain.Student;
import org.szy.service.StudentService;

import java.util.List;

public class MyTest {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        String names[]=ctx.getBeanDefinitionNames();
        for (String name:names){
            System.out.println("��������:"+name+"   "+ctx.getBean(name));
        }
    }

    @Test
    public void testDaoInsert(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //��ȡspring������dao����
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");

        Student student=new Student();
        student.setId(1002);
        student.setName("li");
        student.setEmail("yushen@qq.com");
        student.setAge(20);

        int nums=dao.insertStudent(student);
        System.out.println("nums="+nums);

    }

    @Test
    public void testServiceInsert(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //��ȡspring������dao����
        StudentService service = (StudentService) ctx.getBean("studentService");

        Student student=new Student();
        student.setId(1003);
        student.setName("��ʤ��");
        student.setEmail("shenli@qq.com");
        student.setAge(26);

        int nums=service.addStudent(student);

        //spring��mybatis������һ��ʹ��ʱ���������Զ��ύ�ġ���������SqlSession.commit()
        System.out.println("nums="+nums);

    }

    @Test
    public void testServiceSelect(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //��ȡspring������dao����
        StudentService service = (StudentService) ctx.getBean("studentService");

        List<Student> students=service.queryStudents();
        for (Student stu:students){
            System.out.println(stu);
        }

    }
}
