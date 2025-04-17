package com.asset.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String connString = DBPropertyUtil.getConnectionString("db.properties");
                connection = DriverManager.getConnection(connString);
            } catch (SQLException e) {
                System.out.println("Error connecting to database: " + e.getMessage());
            }
        }
        return connection;
    }
}