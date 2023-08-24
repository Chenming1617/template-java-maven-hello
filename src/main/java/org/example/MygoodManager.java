package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

            System.out.print("请输入商品价格：");
            float price = this.scanner.nextFloat();
            String shit = this.scanner.nextLine();
            
            System.out.print("请输入商品数量：");
            int quantity = this.scanner.nextInt();
            String shit2 = this.scanner.nextLine();
            
            
            
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
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            // 键盘输入商品名称
            System.out.print("请输入商品名称：");
            String name = scanner.nextLine();
            // 检索商品数量并获取结果集
            String selectSql = "SELECT quantity FROM Goods WHERE goodname = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, name);
            ResultSet resultSet = selectStatement.executeQuery();
            int quantity = 0;
            // 如果结果集不为空，获取数量(quantity)
            if (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
            }
            else{
                System.out.println("该商品不存在。");
            }
            // 关闭资源
            resultSet.close();
            selectStatement.close();
            // 如果商品不存在，返回0
            // 键盘输入取出或增加的数量(num)
            System.out.print("请输入要取出(负数)或增加的数量：");
            int num = scanner.nextInt();
            
            // 计算新的数量
            int newQuantity = quantity + num;
            
            // 更新表中的数量
            String updateSql = "UPDATE Goods SET quantity = ? WHERE goodname = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setInt(1, newQuantity);
            updateStatement.setString(2, name);
            int rowsAffected = updateStatement.executeUpdate();
            
            System.out.println(rowsAffected + " 行数据已更新。");
            
            // 关闭资源
            updateStatement.close();
            // 关闭资源
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
    public void SearchGoods(){
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            // 键盘输入商品名称
            System.out.print("请输入商品名称：");
            String name = scanner.nextLine();
            // 检索商品数量并获取结果集
            String selectSql = "SELECT quantity FROM Goods WHERE goodname = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, name);
            ResultSet resultSet = selectStatement.executeQuery();

            int quantity = 0;
            // 如果结果集不为空，获取数量(quantity)
            if (resultSet.next()) {
                int goodId = resultSet.getInt("id");
                quantity = resultSet.getInt("quantity");
                String goodname = resultSet.getString("goodname");
                float price=resultSet.getFloat("price");
                System.out.println("Goods ID: " + goodId);
                System.out.println("Goodname: " + goodname);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: "+price);

            }
            else{
                System.out.println("该商品不存在。");
            }
            resultSet.close();
            selectStatement.close();
         
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }  
    }
    public void listGoods(){
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行查询语句
            String query = "SELECT * FROM Goods";
            ResultSet resultSet = stmt.executeQuery(query);

            // 打印查询结果
            while (resultSet.next()) {
                int goodId = resultSet.getInt("id");
                String goodname = resultSet.getString("goodname");
                int quantity = resultSet.getInt("quantity");
                float price =resultSet.getFloat("price");

                // 可以根据实际的表结构添加其他列信息

                // 打印用户信息
                System.out.println("Goods ID: " + goodId);
                System.out.println("Goodname: " + goodname);
                System.out.println("quantity: " + quantity);
                System.out.println("Price: "+price);
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
}
