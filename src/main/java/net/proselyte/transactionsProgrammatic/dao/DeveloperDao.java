package net.proselyte.transactionsProgrammatic.dao;

import net.proselyte.transactionsProgrammatic.model.Developer;
import net.proselyte.transactionsProgrammatic.model.Project;

import javax.sql.DataSource;
import java.util.List;

public interface DeveloperDao {
    void setDataSource(DataSource dataSource);

    void createDeveloper(String name, String specialty, Integer experience);

    void createDeveloper(Developer developer, List<Project> projects);

    List<Developer> listDevelopers();

    List<Project> listDevelopersProjects(Integer id);
}
