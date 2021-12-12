package com.console.crud.jdbc.app.util;

import com.console.crud.jdbc.app.repository.GenericRepository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionConfig {

    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try (InputStream inputStream = GenericRepository.class.getResourceAsStream("/db.properties")) {
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
