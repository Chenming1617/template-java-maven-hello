package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    private static final String DB_URL1 = "jdbc:sqlite:adm.db";
    private static final String DB_URL2 = "jdbc:sqlite:goods.db";
   // private static final String DB_URL3 = "jdbc:sqlite:shops.db";

    public void initializeDatabaseUser() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("DatabaseUser initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
    public void initializeDatabaseAdm() {
        try (Connection connection = DriverManager.getConnection(DB_URL1);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Adm (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("DatabaseAdm initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
    public void initializeDatabaseGoods() {
        try (Connection connection = DriverManager.getConnection(DB_URL2);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Goods (id INTEGER PRIMARY KEY AUTOINCREMENT, goodname TEXT, quantity INT ,price REAL)";
            statement.executeUpdate(createTableQuery);
            System.out.println("DatabaseGoods initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }

    public void initializeDatabaseShops() {
        try (Connection connection = DriverManager.getConnection(DB_URL2);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Shops (id INTEGER PRIMARY KEY AUTOINCREMENT, shopname TEXT, quantity INT ,price REAL)";
            statement.executeUpdate(createTableQuery);
            System.out.println("DatabaseShops initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }

    public void initializeDatabaseList() {
        try (Connection connection = DriverManager.getConnection(DB_URL2);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS List (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, quantity INT ,price REAL)";
            statement.executeUpdate(createTableQuery);
            System.out.println("DatabaseList initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
}
