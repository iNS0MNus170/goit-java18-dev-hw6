package global.goit.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import global.goit.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    private static final HikariDataSource dataSource;

    static {
        try {
            String url = PropertiesUtil.get("db.url");
            String username = PropertiesUtil.get("db.username");
            String password = PropertiesUtil.get("db.password");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(username);
            config.setPassword(password);

            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            logger.error("Failed to create Hikari DataSource", e);
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if (dataSource == null) {
            logger.error("DataSource is not initialized");
            throw new RuntimeException();
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Error receiving connection", e);
            throw new RuntimeException(e);
        }
    }
}