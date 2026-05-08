package com.rishi.securenotes.storage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/securenotes";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    public static Connection getConnection() throws Exception {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        return connection;
    }
}