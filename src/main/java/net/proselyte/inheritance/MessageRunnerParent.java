package net.proselyte.inheritance;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MessageRunnerParent {
    public static void main(String[] args) {
        String configLocation =
                "file:/C:/temp/springCourse/SpringFromProstyle/SpringHelloTutorial/src/main/resources/" +
                        "inheritance.xml";
        AbstractApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        Message message = (Message) context.getBean("message");
        System.out.println(message);
        MessageToYou messageToYou = (MessageToYou) context.getBean("messageToYou");
        System.out.println(messageToYou);
        context.registerShutdownHook();
    }
}
