package global.goit.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitService.class);

    public static void main(String[] args) {

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            String sqlFilePath = "sql/init_db.sql";
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            statement.execute(sql);
            logger.info("Database structure initialized successfully.");
        } catch (SQLException | IOException e) {
            logger.error("Failed to initialize the database structure", e);
            throw new RuntimeException(e);
        }
    }
}
