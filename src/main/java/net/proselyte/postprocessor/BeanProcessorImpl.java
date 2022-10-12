package net.proselyte.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Date;

public class BeanProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization method called for: " + beanName + ": " + bean);
        if (bean instanceof Message)
            ((Message) bean).setName("new name" + new Date());
        if (bean instanceof SecondBean)
            ((SecondBean) bean).setAge(40);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization method called for: " + beanName);
        return bean;
    }
}
