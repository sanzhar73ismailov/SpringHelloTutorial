package net.proselyte.transactionsProgrammatic.jdbcTemplate;

import net.proselyte.transactionsProgrammatic.dao.DeveloperDao;
import net.proselyte.transactionsProgrammatic.model.Developer;
import net.proselyte.transactionsProgrammatic.model.Project;
import net.proselyte.transactionsProgrammatic.utils.DevelopersMapper;
import net.proselyte.transactionsProgrammatic.utils.ProjectsMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {
    private DataSource dataSource;
    private JdbcTemplate template;
    private PlatformTransactionManager transactionManager;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void createDeveloper(String name, String specialty, Integer experience) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        final String sql = "INSERT INTO DEVELOPERS (NAME, SPECIALTY, EXPERIENCE) VALUES (?,?,?)";
        int update = template.update(sql, name, specialty, experience);
        System.out.println("update = " + update);
        System.out.println("Developer's record created/updated successfully. Name: " +
                name + ", Specilaty: " + specialty + ", Experience: " + experience + "\n");
        transactionManager.commit(status);
    }

    @Override
    public void createDeveloper(Developer developer, List<Project> projects) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        System.out.println("1status.isCompleted()=" + status.isCompleted());
        try {
            Integer developerId = saveDeveloper(developer);
            System.out.println("Developer's record created/updated successfully. Id: " +
                    developerId
                    + ", Name: "
                    + developer.getName()
                    + ", Specilaty: "
                    + developer.getSpecialty()
                    + ", Experience: "
                    + developer.getExperience() + "\n");
            for (Project project : projects) {
                final String projectSql = "INSERT INTO PROJECTS (DEVELOPERS_ID, NAME, COMPANY) VALUES (?,?,?)";
                template.update(projectSql, developerId, project.getProjectName(), project.getCompanyName());
                // System.out.println("Project record created successfully. Project name: " + projectName + ", Company: " + companyName + "\n");
            }
            if(projects.size() < 3) {
                throw new RuntimeException("size of projects only " + projects.size());
            }
            System.out.println("2status.isCompleted()=" + status.isCompleted());
            transactionManager.commit(status);
            System.out.println("3status.isCompleted()=" + status.isCompleted());
        } catch (Exception e) {
            System.out.println("developer is not saved. The cause is " + e.getMessage());
            transactionManager.rollback(status);
            System.out.println("4status.isCompleted()=" + status.isCompleted());
            e.printStackTrace();
        }

    }

    public Integer saveDeveloper(Developer developer) {
        String insertSql = "INSERT INTO DEVELOPERS (NAME, SPECIALTY, EXPERIENCE) VALUES (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"DEVELOPER_ID"});
            ps.setString(1, developer.getName());
            ps.setString(2, developer.getSpecialty());
            ps.setInt(3, developer.getExperience());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Developer> listDevelopers() {
        final String sql = "SELECT * FROM DEVELOPERS";
        return template.query(sql, new DevelopersMapper());
    }

    @Override
    public List<Project> listDevelopersProjects(Integer id) {
        final String sql = "SELECT * FROM PROJECTS WHERE DEVELOPERS_ID = " + id;
        return template.query(sql, new ProjectsMapper());
    }
}
