package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class MygoodManager {
    private static final String DB_URL = "jdbc:sqlite:goods.db";
    private Scanner scanner = null;

    public MygoodManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addGoods(){
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            
            // 预处理语句，用于插入数据
            String sql = "INSERT INTO Goods (goodname, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // 键盘输入数据
            //Scanner scanner = new Scanner(System.in);
            
            System.out.print("请输入商品名称：");
            String goodname = this.scanner.nextLine();
            
            System.out.print("请输入商品数量：");
            int quantity = this.scanner.nextInt();
            
            System.out.print("请输入商品价格：");
            float price = this.scanner.nextFloat();
            
            // 设置预处理语句的参数
            statement.setString(1, goodname);
            statement.setInt(2, quantity);
            statement.setFloat(3, price);
            
            // 执行预处理语句，将数据插入到表中
            int rowsAffected = statement.executeUpdate();
            
            System.out.println(rowsAffected + " 行数据已插入到表中。");
            
            // 关闭资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }

    public void deleteGoods(){
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            
            // 预处理语句，删除数据
            String sql = "DELETE FROM Goods WHERE goodname = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // 键盘输入数据
            System.out.print("请输入商品名称：");
            String goodname = this.scanner.nextLine();
            // 设置预处理语句的参数
            statement.setString(1, goodname);   
            // 执行预处理语句，将数据插入到表中
            int rowsAffected = statement.executeUpdate();
            
            System.out.println("Deleted "+ rowsAffected + " rows.");
            // 关闭资源
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }

    public void alterGoods(){

    }

    public void SearchGoods(){

    }
}
