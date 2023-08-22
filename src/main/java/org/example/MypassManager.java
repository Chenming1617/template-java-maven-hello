package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MypassManager {
    private static final String DB_URL1 = "jdbc:sqlite:users.db";
    private static final String DB_URL2 = "jdbc:sqlite:adm.db";
    public boolean registerUser(String username, String password) {//用户注册
        try (Connection connection = DriverManager.getConnection(DB_URL1);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("User registered successfully!");

            return true;
        } catch (SQLException e) {
            System.out.println("Failed to register user: " + e.getMessage());
        }

        return false;
    }
    public boolean registerAdm(String username, String password) {//管理员注册
        try (Connection connection = DriverManager.getConnection(DB_URL2);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Adm (username, password) VALUES (?, ?)")) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("Adm registered successfully!");

            return true;
        } catch (SQLException e) {
            System.out.println("Failed to register user: " + e.getMessage());
        }

        return false;
    }
    public boolean loginUser(String username, String password) {//用户登录
        try (Connection connection = DriverManager.getConnection(DB_URL1);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
    
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (password.equals(storedPassword)) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Incorrect password.");
                }
            } else {
                System.out.println("Username does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to login: " + e.getMessage());
        }
        return false;
    }
    public boolean loginAdm(String username, String password) {//管理员登录
        try (Connection connection = DriverManager.getConnection(DB_URL2);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Adm WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
    
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (password.equals(storedPassword)) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Incorrect password.");
                }
            } else {
                System.out.println("Admname does not exist.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to login: " + e.getMessage());
        }
        return false;
    }
}
