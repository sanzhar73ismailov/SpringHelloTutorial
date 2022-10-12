package net.proselyte.postprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MessageRunnerIPostProcessor {
    public static void main(String[] args) {
        String configLocation =
                "file:/C:/temp/springCourse/SpringFromProstyle/SpringHelloTutorial/src/main/resources/" +
                        "post-processor-config.xml";
        AbstractApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        Message message = (Message) context.getBean("message");
        System.out.println(message);
        context.registerShutdownHook();
    }
}
