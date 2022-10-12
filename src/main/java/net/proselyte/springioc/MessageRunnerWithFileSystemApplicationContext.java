package net.proselyte.springioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MessageRunnerWithFileSystemApplicationContext {
    public static void main(String[] args) {
        ApplicationContext context = 
                new FileSystemXmlApplicationContext(
                "file:/C:/temp/springCourse/SpringFromProstyle/SpringHelloTutorial/src/main/resources/message-bean.xml");
        //or
//                        "file:\\C:\\temp\\springCourse\\SpringFromProstyle\\SpringHelloTutorial\\src\\main\\resources\\message-bean.xml");
        //or
//                "classpath:message-bean.xml");
        Message message = (Message) context.getBean("fromBeanMessage");
        System.out.println(message.getMessage());
    }
}
