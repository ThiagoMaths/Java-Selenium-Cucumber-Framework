package com.tutorialsninja.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLiteHandler {

    private static final Logger log = LoggerFactory.getLogger(SQLiteHandler.class);

    private static final String DB_URL = "jdbc:sqlite:test.db";
    private static Connection connection;
    private static int counter = 0;

    public SQLiteHandler() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            createUserTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "password VARCHAR(255) NOT NULL)";

        try (Statement statement = connection.createStatement()) {

            statement.execute(sql);
            log.info("Table created");
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Table creation failed");
        }
    }

    public void insertUser(String email, String password) {
        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            counter++;


        } catch (SQLException e) {
            e.printStackTrace();
            log.info("Insert failed");
        }
    }

    public String getRandomEmail() {
        String sql = "SELECT EMAIL FROM users ORDER BY RANDOM() LIMIT 1";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return resultSet.getString("email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getRandomEmailAndPassword() {
        Map<String, String> credentials = new HashMap<String, String>();
        String email = null;
        String password = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT email, password FROM users ORDER BY RANDOM() LIMIT 1")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                email = resultSet.getString("email");
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        credentials.put("email", email);
        credentials.put("password", password);

        return credentials;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
