package com.spring.basic;

import com.spring.dao.StudentDao;
import com.spring.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 1 . setting hello mesage using classpathxmlapplication context
 * 2. using component scan to scan dir and set beans
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringBeans.xml");
        HelloWorldBean helloWorldBean = (HelloWorldBean) applicationContext.getBean("messageBean");
        System.out.println(helloWorldBean.getMessage());

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"SpringBeans-AutoScan.xml"});

        StudentService studentService = (StudentService) context.getBean("studentServiceImpl");
        StudentDao studentDao = (StudentDao) context.getBean("studentDaoImpl");
        studentDao.setName("siddy");
        System.out.println(studentService.getData());
    }
}
