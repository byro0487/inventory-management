package org.inventory.management.helpers;

import org.inventory.management.config.Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public static Connection getConnection() throws SQLException {
        loadDriver();
        // Connect to the H2 in-memory database
        return DriverManager.getConnection(Configurations.DB_CONNECTION_URL, Configurations.DB_USER_NAME, Configurations.DB_PASSWORD);
    }

    private static void loadDriver(){
        // Load the H2 JDBC driver
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



}
