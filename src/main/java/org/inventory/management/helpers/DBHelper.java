package org.inventory.management.helpers;

import org.inventory.management.config.Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Provides utility methods to manage database connections.
 */
public class DBHelper {
    /**
     * Establishes and returns a connection to the database using the configuration parameters.
     *
     * @return A Connection object to the configured database.
     * @throws SQLException If a database access error occurs or the url is {@code null}.
     */
    public static Connection getConnection() throws SQLException {
        loadDriver();
        // Connect to the H2 in-memory database
        return DriverManager.getConnection(Configurations.DB_CONNECTION_URL, Configurations.DB_USER_NAME, Configurations.DB_PASSWORD);
    }
    /**
     * Loads the H2 JDBC driver to enable database connections.
     *
     * @throws RuntimeException If the driver class is not found.
     */
    private static void loadDriver(){
        // Load the H2 JDBC driver
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
