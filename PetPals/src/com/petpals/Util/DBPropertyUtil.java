

package com.petpals.Util;



import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static Properties getProperties() {
        Properties props = new Properties();
        try {
            InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream("db.properties");
            if (input == null) {
                throw new RuntimeException("❌ db.properties file not found in classpath.");
            }
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
}