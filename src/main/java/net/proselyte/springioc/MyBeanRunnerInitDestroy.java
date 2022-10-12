package net.proselyte.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyBeanRunnerInitDestroy {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new FileSystemXmlApplicationContext(
                "file:/C:/temp/springCourse/SpringFromProstyle/SpringHelloTutorial/src/main/resources/message-bean.xml");
        MyBean message = (MyBean) context.getBean("myBean");
        System.out.println(message.getMessage());
        context.registerShutdownHook();
    }
}
