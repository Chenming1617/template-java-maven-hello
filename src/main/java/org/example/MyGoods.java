package org.example;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class MyGoods {
    private Map<String, MyGoods> goodsMap; // 用Map来存储商品对象，key为name，value为节点
    private Scanner scanner = null;
    private String id;
    private String name;
    private String manufacturer;
    private double Price;
    private int quantity;
    public MyGoods() {
        
    };

    public MyGoods(String id, String name, String manufacturer, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        Price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void addGoods(){
        System.out.println("请输入goodsID: ");
        String goodsID=this.scanner.nextLine();
        System.out.println("请输入goodsname: ");
        String goodsname=this.scanner.nextLine();
        System.out.println("请输入manufacturer: ");
        String manufacturer1=this.scanner.nextLine();
        System.out.println("请输入price: ");
        float price=this.scanner.nextFloat();
        String delete = this.scanner.nextLine();//铲屎
        System.out.println("请输入quantity:"+delete);
        int quantity1=this.scanner.nextInt();
        String delete1 = this.scanner.nextLine();//铲屎

        MyGoods good=new MyGoods(goodsID, goodsname, manufacturer1, price, quantity1);
        goodsMap.put(good.getName(), good);
        System.out.println("添加完成！"+delete1);
    }
    public void deltGoods(){

    }
    public void alterGoods(){

    }
    public void searchGoods(){

    }
    public void listGoods(){

    }
    public static void writeGoodsToFile(MyGoods goods) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Goods.txt"))) {
          // 写入第一行的标题
        //   writer.write("Id\tname\tmanufacturer\tprice\tquantity");
        //   writer.newLine();
    
          // 写入第二行的内容
          writer.write(goods.getId() + "\t" +
                       goods.getName() + "\t" +
                       goods.getManufacturer() + "\t" +
                       goods.getPrice() + "\t" +
                       goods.getQuantity());
          writer.newLine();
    
          System.out.println("Goods data written to file successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while writing goods data to file.");
          e.printStackTrace();
        }
      }

}