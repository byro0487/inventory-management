package org.inventory.management.helpers;

import org.inventory.management.config.Configurations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2TableCreator {

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

