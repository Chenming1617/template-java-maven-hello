package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyshopManager {
    private static final String DB_URL = "jdbc:sqlite:goods.db";
    private Scanner scanner = null;

    public MyshopManager(Scanner scanner) {
        this.scanner = scanner;
    }
    public void listGoods(){//展示商店的货物
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
    public void listShops(){
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行查询语句
            String query = "SELECT * FROM Shops";
            ResultSet resultSet = stmt.executeQuery(query);

            // 打印查询结果
            while (resultSet.next()) {
                int shopId = resultSet.getInt("id");
                String shopname = resultSet.getString("shopname");
                int quantity = resultSet.getInt("quantity");
                float price =resultSet.getFloat("price");

                // 可以根据实际的表结构添加其他列信息

                // 打印用户信息
                System.out.println("Goods ID: " + shopId);
                System.out.println("Goodname: " + shopname);
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
    public void addShops(){//加购物车
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            
            // 键盘输入物品名称
            System.out.print("请输入物品名称：");
            String goodname = scanner.nextLine();
            
            // 查询Goods表中是否存在相关信息
            String selectSql = "SELECT * FROM Goods WHERE goodname = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, goodname);
            ResultSet resultSet = selectStatement.executeQuery();
            
            if (!resultSet.next()) {
                System.out.println("商店没有此货物。");
            } else {
                // 键盘输入新的数量
                System.out.print("请输入加入购物车的商品数量：");
                int newquantity = scanner.nextInt();
                String shit =scanner.nextLine();
                
                // 获取Goods表中的goodname和price数据
                float price = resultSet.getFloat("price");
                
                // 在Shops表中插入数据
                String insertSql = "INSERT INTO Shops (shopname, price, quantity) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setString(1, goodname);
                insertStatement.setFloat(2, price);
                insertStatement.setInt(3, newquantity);
                int rowsAffected = insertStatement.executeUpdate();
                
                System.out.println(rowsAffected + " 行数据已插入Shops表");
                
                // 关闭资源
                insertStatement.close();
            }
            
            // 关闭资源
            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
    public void deleteShops(){
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            
            // 预处理语句，删除数据
            String sql = "DELETE FROM Shops WHERE shopname = ?";
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
    public void alterShops(){
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);
            // 键盘输入商品名称
            System.out.print("请输入商品名称：");
            String name = scanner.nextLine();
            // 检索商品数量并获取结果集
            String selectSql = "SELECT quantity FROM Shops WHERE shopname = ?";
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
            System.out.print("请输入要删除(负数)或增加的数量：");
            int num = scanner.nextInt();
            String shit3=scanner.nextLine();
            
            // 计算新的数量
            int newQuantity = quantity + num;
            
            // 更新表中的数量
            String updateSql = "UPDATE Shops SET quantity = ? WHERE shopname = ?";
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
            System.out.println("Failed to initialize database: " + e.getMessage());
        }    
    }
    public void checkShops(){
        try {
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(DB_URL);

            // 键盘输入商品名称和取出的商品数量
    
            System.out.print("请输入商品名称：");
            String shopname = scanner.nextLine();
            System.out.print("请输入取出的商品数量：");
            int newquantity = scanner.nextInt();
            String shit1=scanner.nextLine();

            // 更新Goods表中对应行的数量
            String updateGoodsSql = "UPDATE Goods SET quantity = quantity - ? WHERE goodname = ?";
            PreparedStatement updateGoodsStatement = connection.prepareStatement(updateGoodsSql);
            updateGoodsStatement.setInt(1, newquantity);
            updateGoodsStatement.setString(2, shopname);
            int goodsRowsAffected = updateGoodsStatement.executeUpdate();

            if (goodsRowsAffected == 0) {
                System.out.println("没有找到对应的商品信息。");
            } else {
                System.out.println("成功更新Goods表中的数据。");

                // 更新Shops表中对应行的数量和计算pay变量
                String updateShopsSql = "UPDATE Shops SET quantity = quantity - ? WHERE shopname = ?";
                String selectPriceSql = "SELECT price FROM Shops WHERE shopname = ?";
                PreparedStatement updateShopsStatement = connection.prepareStatement(updateShopsSql);
                PreparedStatement selectPriceStatement = connection.prepareStatement(selectPriceSql);
                selectPriceStatement.setString(1, shopname);
                ResultSet priceResultSet = selectPriceStatement.executeQuery();

                if (priceResultSet.next()) {
                    float price = priceResultSet.getFloat("price");
                    float pay = price * newquantity;

                    updateShopsStatement.setInt(1, newquantity);
                    updateShopsStatement.setString(2, shopname);
                    int shopsRowsAffected = updateShopsStatement.executeUpdate();

                    if (shopsRowsAffected == 0) {
                        System.out.println("没有找到对应的商品信息。");
                    } else {
                            System.out.println("成功更新Shops表中的数据。");
                            System.out.println("pay = " + pay);
                            String insertListSql = "INSERT INTO List (name, quantity, price) VALUES (?, ?, ?)";
                            PreparedStatement insertListStatement = connection.prepareStatement(insertListSql);
                            insertListStatement.setString(1, shopname);
                            insertListStatement.setInt(2, newquantity);
                            insertListStatement.setFloat(3, pay);
                            int listRowsAffected = insertListStatement.executeUpdate();

                            if (listRowsAffected > 0) {
                                System.out.println("成功将数据插入到L购物历史记录List表中。");
                            } else {
                                System.out.println("插入数据到List表时出现问题。");
                            }

                                // 关闭资源
                            insertListStatement.close();
                        
                        
                    }
                } else {
                    System.out.println("没有找到对应的商品信息。");
                }

                // 关闭资源
                selectPriceStatement.close();
                priceResultSet.close();
                updateShopsStatement.close();
            }

            // 关闭资源
            updateGoodsStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }
    public void listShopHistory(){
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // 创建Statement对象
            Statement stmt = conn.createStatement();

            // 执行查询语句
            String query = "SELECT * FROM List";
            ResultSet resultSet = stmt.executeQuery(query);

            // 打印查询结果
            while (resultSet.next()) {
                int goodId = resultSet.getInt("id");
                String goodname = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                float price =resultSet.getFloat("price");

                // 可以根据实际的表结构添加其他列信息

                // 打印用户信息
                System.out.println("Shops ID: " + goodId);
                System.out.println("Shopsname: " + goodname);
                System.out.println("quantity: " + quantity);
                System.out.println("PayPrice: "+price);
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
