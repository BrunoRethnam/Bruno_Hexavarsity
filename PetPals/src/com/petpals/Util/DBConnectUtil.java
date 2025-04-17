package com.petpals.Util;





import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnectUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties props = DBPropertyUtil.getProperties();
            Class.forName(props.getProperty("driver"));
            connection = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("username"),
                    props.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}