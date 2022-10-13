package net.proselyte.jdbctemplate;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcDeveloperRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:jbbctemplate-developer-config.xml");

        JdbcTemplateDeveloperDaoImpl dao = (JdbcTemplateDeveloperDaoImpl) context.getBean("jdbcTemplateDeveloperDao");

        System.out.println("========Creating new records to DB========");
        dao.createDeveloper("Proselyte", "Java Developer", 3);
        dao.createDeveloper("Petr", "C++ Developer", 2);
        dao.createDeveloper("DesignerAsya", "UI Developer", 1);

        System.out.println("========Developers List========");
        List<Developer> developers = dao.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }

        System.out.println("========Some changes to DB========");
        dao.updateDeveloper(33, "DesignerAsya", "UI Developer", 2);
        dao.removeDeveloper(32);

        System.out.println("========Final Developers List========");
        List<Developer> finalDevelopers = dao.listDevelopers();
        for (Developer developer : finalDevelopers) {
            System.out.println(developer);
        }
    }
}

