package global.goit.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    private static final Logger logger = LoggerFactory.getLogger(DatabasePopulateService.class);

    public static void main(String[] args) {
        String filePath = "sql/populate_db.sql";
        String sqlCommands = readSqlFile(filePath);
        if (sqlCommands == null) {
            System.err.println("Failed to read SQL query file.");
            return;
        }
        executeSqlCommands(sqlCommands);
    }

    private static String readSqlFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            logger.error("Error reading SQL file at path: {}", filePath, e);
            return null;
        }
    }

    private static void executeSqlCommands(String sqlCommands) {
        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            String[] commands = sqlCommands.split(";");
            for (String command : commands) {
                if (!command.trim().isEmpty()) {
                    statement.execute(command);
                }
            }
            logger.info("The database tables were successfully populated.");
        } catch (SQLException e) {
            logger.error("SQL execution error.", e);
            throw new RuntimeException(e);
        }
    }
}
