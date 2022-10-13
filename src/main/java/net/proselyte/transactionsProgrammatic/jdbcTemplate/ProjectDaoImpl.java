package net.proselyte.transactionsProgrammatic.jdbcTemplate;

import net.proselyte.transactionsProgrammatic.dao.ProjectDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class ProjectDaoImpl implements ProjectDao {
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
    public void createProject(Integer developerId, String projectName, String companyName) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);

        final String sql = "INSERT INTO PROJECTS (DEVELOPERS_ID, NAME, COMPANY) VALUES (?,?,?)";
        template.update(sql, developerId, projectName, companyName);
        System.out.println("Project record created successfully. Project name: " + projectName + ", Company: " + companyName + "\n");
        transactionManager.commit(status);
    }
}
