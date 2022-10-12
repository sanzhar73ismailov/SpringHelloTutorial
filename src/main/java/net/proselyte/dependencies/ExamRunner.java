package net.proselyte.dependencies;

import net.proselyte.inheritance.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamRunner {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("exam-config.xml");
        Exam exam = (Exam) context.getBean("exam");
        exam.examCheck();
    }
}
