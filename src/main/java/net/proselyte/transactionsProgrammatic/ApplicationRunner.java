package net.proselyte.transactionsProgrammatic;

import net.proselyte.transactionsProgrammatic.jdbcTemplate.DeveloperDaoImpl;
import net.proselyte.transactionsProgrammatic.jdbcTemplate.ProjectDaoImpl;
import net.proselyte.transactionsProgrammatic.model.Developer;
import net.proselyte.transactionsProgrammatic.model.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:transactions-programmatic-config.xml");
        DeveloperDaoImpl developerDao = (DeveloperDaoImpl) context.getBean("developerJDBCTemplate");

        System.out.println("======== Creating developer's records ========");
        developerDao.createDeveloper(new Developer("Proselyte", "Java Developer", 3),
                Arrays.asList(
                        new Project("pr1_" + System.currentTimeMillis(), "company1"),
                        new Project("pr2_"+ System.currentTimeMillis(), "company2")
                )
        );
    }

    public static void main1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:transactions-programmatic-config.xml");
        DeveloperDaoImpl developerDao = (DeveloperDaoImpl) context.getBean("developerJDBCTemplate");
        ProjectDaoImpl projectDao = (ProjectDaoImpl) context.getBean("projectJDBCTemplate");

        System.out.println("======== Creating project's records ========");
        projectDao.createProject(82, "ProselyteTutorial", "Proselyte.net");
        projectDao.createProject(82, "SkybleLib", "SkybleSoft");

        System.out.println("======== Creating developer's records ========");
        developerDao.createDeveloper("Proselyte", "Java Developer", 3);
        developerDao.createDeveloper("Mike", "C++ Developer", 5);

        System.out.println("======== List of Developers ========");
        List<Developer> developerList = developerDao.listDevelopers();
        for (Developer developer : developerList) {
            System.out.println(developer);
        }

        System.out.println("======== Proselyte Developer's Projects ========");
        List<Project> projects = developerDao.listDevelopersProjects(82);
        for (Project project : projects) {
            System.out.println(project);
        }

    }
}
