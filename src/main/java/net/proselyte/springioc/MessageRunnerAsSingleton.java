package net.proselyte.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MessageRunnerAsSingleton {
    public static void main(String[] args) {
        ApplicationContext context = 
                new FileSystemXmlApplicationContext(
                "file:/C:/temp/springCourse/SpringFromProstyle/SpringHelloTutorial/src/main/resources/message-bean.xml");
        Message message1 = (Message) context.getBean("printMessage");
        System.out.println("message1.getMessage(): "+message1.getMessage());
        message1.setMessage("111");
        System.out.println("message1 = " + message1);
        System.out.println("message1.getMessage() after setting: "+message1.getMessage());
        Message  message2 = (Message) context.getBean("printMessage");
        System.out.println("message2.getMessage() " + message2.getMessage());
        System.out.println("message2 = " + message2);
        System.out.println(message1==message2);
    }
}
