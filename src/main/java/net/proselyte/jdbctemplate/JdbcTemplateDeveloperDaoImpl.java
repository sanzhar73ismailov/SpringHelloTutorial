package net.proselyte.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createDeveloper(String name, String specialty, Integer experience) {
        String SQL = "INSERT INTO DEVELOPERS (name, specialty, experience) VALUES (?,?,?)";

        jdbcTemplate.update(SQL, name, specialty, experience);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpecilaty: " +
                specialty + ";\nExperience: " + experience + "\n");
    }

    @Override
    public Developer getDeveloperById(Integer id) {
        String SQL = "SELECT * FROM DEVELOPERS WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DeveloperMapper());
    }

    @Override
    public List<Developer> listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        return jdbcTemplate.query(SQL, new DeveloperMapper());
    }

    @Override
    public void removeDeveloper(Integer id) {
        String SQL = "DELETE FROM DEVELOPERS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Developer with id: " + id + " successfully removed");
    }

    @Override
    public void updateDeveloper(Integer id, String name, String specialty, Integer experience) {
        String SQL = "UPDATE DEVELOPERS SET name = ?, specialty = ?, experience = ? WHERE id = ?";
        jdbcTemplate.update(SQL, name, specialty, experience, id);
        System.out.println("Developer with id: " + id + " successfully updated.");
    }
}
