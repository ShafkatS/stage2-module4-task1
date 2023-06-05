package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
@Override
    public Connection createConnection() {
        Properties properties = new Properties();
        String propFileName = "h2database.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        while (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            return DriverManager.getConnection(
                    properties.getProperty("jdbc:h2:~/test"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

