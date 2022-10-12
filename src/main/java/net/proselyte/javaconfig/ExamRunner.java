package net.proselyte.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamRunner {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class);
        Exam exam =  context.getBean("examBean", Exam.class);
     //   Exam exam =  context.getBean("exam2", Exam.class);
        exam.examCheck();
    }
}
