package net.proselyte.annotationsrequired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeveloperRunner {
    public static void main(String[] args) {
        //annotation-config_reqired.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config_reqired.xml");
//        Developer developer = context.getBean(Developer.class);
        Developer developer = (Developer) context.getBean("developer");
        System.out.println("developer = " + developer);
    }
}
