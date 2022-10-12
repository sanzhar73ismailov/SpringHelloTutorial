package net.proselyte.springioc;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MessageRunnerWithBeanFactory {
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("message-bean.xml"));
        Message message = (Message) factory.getBean("fromBeanMessage");
        System.out.println(message.getMessage());
    }
}
