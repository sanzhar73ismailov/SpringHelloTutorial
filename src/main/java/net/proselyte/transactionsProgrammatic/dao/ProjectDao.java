package net.proselyte.transactionsProgrammatic.dao;

import javax.sql.DataSource;

public interface ProjectDao {
    void setDataSource(DataSource dataSource);

    void createProject(Integer developerId, String projectName, String companyName);
}
