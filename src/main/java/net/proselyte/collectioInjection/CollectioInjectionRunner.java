package net.proselyte.collectioInjection;

import net.proselyte.dependencies.Exam;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectioInjectionRunner {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("collection-injection-config.xml");
        CollectionInjection bean = (CollectionInjection) context.getBean("collectionInjection");
        List documentList = bean.getDocumentList();
        Set documentSet = bean.getDocumentSet();
        Map documentMap = bean.getDocumentMap();
        Properties documentProp = bean.getDocumentProp();

    }
}
