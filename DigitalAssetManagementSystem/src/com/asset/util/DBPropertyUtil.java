package com.asset.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getConnectionString(String propertyFileName) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFileName)) {
            props.load(fis);
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            return url + "?user=" + user + "&password=" + password;
        } catch (IOException e) {
            System.out.println("Error reading DB property file: " + e.getMessage());
        }
        return null;
    }
}
