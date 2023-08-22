package org.example;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MypassAlter {
    private static final String DB_URL1 = "jdbc:sqlite:users.db";
    private static final String DB_URL2 = "jdbc:sqlite:adm.db";

    private Scanner scanner = null;
    private MypassManager Manager = null;

    public MypassAlter(Scanner scanner, MypassManager Manager) {
        this.scanner = scanner;
        this.Manager = Manager;
    }
    public void alterUserpass(){
        try (Connection conn = DriverManager.getConnection(DB_URL1)) {
            // 从命令行输入用户名、旧密码和新密码
            System.out.print("Enter username: ");
            String usernameInput = this.scanner.nextLine();
            System.out.print("Enter old password: ");
            String oldPasswordInput = this.scanner.nextLine();
            System.out.print("Enter new password: ");
            String newPasswordInput = this.scanner.nextLine();

            // 检查用户是否存在并验证旧密码
            String selectQuery = "SELECT id FROM Users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
                stmt.setString(1, usernameInput);
                stmt.setString(2, oldPasswordInput);
                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    int userId = resultSet.getInt("id");

                    // 更新用户密码
                    String updateQuery = "UPDATE Users SET password = ? WHERE id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, newPasswordInput);
                        updateStmt.setInt(2, userId);
                        updateStmt.executeUpdate();
                    }

                    System.out.println("Password updated successfully,please relogin again!");
                } else {
                    System.out.println("Incorrect username or old password.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
    public void alterAdmpass(){
        try (Connection conn = DriverManager.getConnection(DB_URL2)) {
            // 从命令行输入用户名、旧密码和新密码
            System.out.print("Enter username: ");
            String usernameInput = this.scanner.nextLine();
            System.out.print("Enter old password: ");
            String oldPasswordInput = this.scanner.nextLine();
            System.out.print("Enter new password: ");
            String newPasswordInput = this.scanner.nextLine();

            // 检查用户是否存在并验证旧密码
            String selectQuery = "SELECT id FROM Adm WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
                stmt.setString(1, usernameInput);
                stmt.setString(2, oldPasswordInput);
                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    int userId = resultSet.getInt("id");

                    // 更新用户密码
                    String updateQuery = "UPDATE Adm SET password = ? WHERE id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, newPasswordInput);
                        updateStmt.setInt(2, userId);
                        updateStmt.executeUpdate();
                    }

                    System.out.println("Password updated successfully,please relogin again!");
                } else {
                    System.out.println("Incorrect username or old password.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }

    }
    public void listUserinf(){
        try (Connection conn = DriverManager.getConnection(DB_URL1)) {
            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行查询语句
            String query = "SELECT * FROM Users";
            ResultSet resultSet = stmt.executeQuery(query);

            // 打印查询结果
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // 可以根据实际的表结构添加其他列信息

                // 打印用户信息
                System.out.println("User ID: " + userId);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                // 可以打印其他列信息
                System.out.println("--------------------------------------");
            }

            // 关闭Statement和ResultSet
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
    public void deltUserinf(){

    }
    public void searchUserinf(){

    }
}
