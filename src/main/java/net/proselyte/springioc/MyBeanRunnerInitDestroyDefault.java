package net.proselyte.springioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyBeanRunnerInitDestroyDefault {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new FileSystemXmlApplicationContext(
                "file:/C:/temp/springCourse/SpringFromProstyle/SpringHelloTutorial/src/main/resources/message-bean_init_destry_default.xml");
        MyBean message = (MyBean) context.getBean("myBean");
        System.out.println(message.getMessage());
        context.registerShutdownHook();
    }
}
