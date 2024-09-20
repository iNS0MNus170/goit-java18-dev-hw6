package global.goit.database;

import global.goit.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseQueryService.class);

    private String readSqlFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement stmt = connection.createStatement()) {

            String query = readSqlFromFile("sql/find_max_projects_client.sql");
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(rs.getString("name"));
                client.setProjectCount(rs.getInt("project_count"));
                result.add(client);
            }

        } catch (Exception e) {
            logger.error("Error executing findMaxProjectsClient query", e);
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement stmt = connection.createStatement()) {

            String query = readSqlFromFile("sql/find_max_salary_worker.sql");
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker();
                worker.setName(rs.getString("name"));
                worker.setSalary(rs.getInt("salary"));
                result.add(worker);
            }

        } catch (Exception e) {
            logger.error("Error executing findMaxSalaryWorker query", e);
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement stmt = connection.createStatement()) {

            String query = readSqlFromFile("sql/find_youngest_eldest_workers.sql");
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                YoungestEldestWorkers worker = new YoungestEldestWorkers();
                worker.setType(rs.getString("type"));
                worker.setName(rs.getString("name"));
                worker.setBirthday(rs.getString("birthday"));
                result.add(worker);
            }

        } catch (Exception e) {
            logger.error("Error executing findYoungestEldestWorkers query", e);
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement stmt = connection.createStatement()) {

            String query = readSqlFromFile("sql/find_longest_project.sql");
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                LongestProject project = new LongestProject();
                project.setName(rs.getString("id"));
                project.setMonthCount(rs.getInt("month_count"));
                result.add(project);
            }

        } catch (Exception e) {
            logger.error("Error executing findLongestProject query", e);
        }
        return result;
    }

    public List<ProjectPrices> printProjectPrices() {
        List<ProjectPrices> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement stmt = connection.createStatement()) {

            String query = readSqlFromFile("sql/print_project_prices.sql");
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                ProjectPrices price = new ProjectPrices();
                price.setName(rs.getString("ID"));
                price.setPrice(rs.getInt("PRICE"));
                result.add(price);
            }

        } catch (Exception e) {
            logger.error("Error executing printProjectPrices query", e);
        }
        return result;
    }
}
