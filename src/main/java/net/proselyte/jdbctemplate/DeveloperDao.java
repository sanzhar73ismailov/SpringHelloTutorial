package net.proselyte.jdbctemplate;

import javax.sql.DataSource;
import java.util.List;

interface DeveloperDao {
    void setDataSource(DataSource dataSource);

    void createDeveloper(String name, String specialty, Integer experience);

    Developer getDeveloperById(Integer id);

    List<Developer> listDevelopers();

    void removeDeveloper(Integer id);

    void updateDeveloper(Integer id, String name, String specialty, Integer experience);
}
