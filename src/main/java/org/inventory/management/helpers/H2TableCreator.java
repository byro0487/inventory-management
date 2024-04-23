package org.inventory.management.helpers;

import org.inventory.management.config.Configurations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Utility class for creating tables in an H2 database.
 * This class provides methods to initialize the database schema for an inventory management system.
 */
public class H2TableCreator {
    /**
     * Creates tables in the database using SQL scripts.
     * This method establishes a connection to the database, loads the JDBC driver,
     * and executes SQL scripts from specified files.
     */
    public static void createTables() {
        String jdbcUrl = Configurations.DB_CONNECTION_URL;
        String username = Configurations.DB_USER_NAME;
        String password = Configurations.DB_PASSWORD;

        // Load the H2 JDBC driver
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            // Read SQL statements from files and execute them
            executeSqlFromFile(stmt, "inventory_store.sql");
            executeSqlFromFile(stmt, "product.sql");
            executeSqlFromFile(stmt, "store.sql");
            executeSqlFromFile(stmt, "store_product.sql");

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Executes SQL statements read from a file.
     * @param stmt The statement object used for executing the SQL queries.
     * @param filePath The path to the SQL file containing the queries.
     * @throws SQLException If an SQL error occurs during query execution.
     */
    private static void executeSqlFromFile(Statement stmt, String filePath) throws SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/venu/Downloads/inventory-manegement/src/main/resources/schema/"+filePath))) {
            StringBuilder sqlStatements = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlStatements.append(line);
                sqlStatements.append("\n");
            }
            String[] sqlQueries = sqlStatements.toString().split(";");
            for (String query : sqlQueries) {
                stmt.executeUpdate(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

