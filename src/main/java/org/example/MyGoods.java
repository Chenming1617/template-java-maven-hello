package org.example;
import java.util.Map;
import java.util.Scanner;
public class MyGoods {
    private Map<String, MyGoods> goodsMap; // 用Map来存储商品对象，key为name，value为节点
    private Scanner scanner = null;
    private int id;
    private String name;
    private String manufacturer;
    private double Price;
    private int quantity;
    public MyGoods() {
        
    };

    public MyGoods(int id, String name, String manufacturer, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        Price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}