package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}

