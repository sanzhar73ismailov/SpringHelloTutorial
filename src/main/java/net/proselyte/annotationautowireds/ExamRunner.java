package net.proselyte.annotationautowireds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamRunner {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("annotation-config_autowired.xml");
        Exam exam = (Exam) context.getBean("exam");
        exam.examCheck();
    }
}
