package org.example;
import java.util.LinkedHashMap;
//import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class MyGoods {
    private static LinkedHashMap<String, MyGoods> goodsMap =new LinkedHashMap<String, MyGoods>(); // 用Map来存储商品对象，key为name，value为节点
    private Scanner scanner = null;
    private String id;
    private String name;
    private String manufacturer;
    private double Price;
    private int quantity;
    public MyGoods(Scanner scanner) {
        this.scanner=scanner;
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
        System.out.println("请输入goodsname: ");
        String goodsname=scanner.nextLine();
        if(goodsMap.containsKey(goodsname)){
            System.out.println("该商品已经存在，如果想修改数值，请选择修改商品！");
        }else{
            System.out.println("请输入goodsid: ");
            String goodsid=scanner.nextLine();
            System.out.println("请输入manufacturer: ");
            String manufacturer1=this.scanner.nextLine();
            System.out.println("请输入price: ");
            float price=this.scanner.nextFloat();
            String delete = this.scanner.nextLine();//铲屎
            System.out.println("请输入quantity: "+delete);
            int quantity1=this.scanner.nextInt();
            String delete1 = this.scanner.nextLine();//铲屎

            MyGoods good=new MyGoods(goodsid, goodsname, manufacturer1, price, quantity1);
            goodsMap.put(good.getName(), good);
            System.out.println("添加完成！"+delete1);
        
        }
    }
    public void deltGoods(){
        System.out.println("请输入goodsName: ");
        String goodsName=this.scanner.nextLine();
        MyGoods removegoods = goodsMap.remove(goodsName);
        if (removegoods == null) {
            System.out.println("删除失败，商品不存在");
        } else {
            System.out.println("Have deleted " + removegoods.getName()+" "+removegoods.getName());
        }
    }
    public void alterGoods(){
        System.out.println("请输入goodsName: ");
        String goodsName=this.scanner.nextLine();
        if(!goodsMap.containsKey(goodsName)){
            System.out.println("根据商品名找不到该商品");
        }
        else{
            while (true) {
                System.out.println("What do you want to alter,0 GoodsID,1 Goodsname,2 manufacturer,3 price,4 quantity,q exit");
                String num = scanner.nextLine();
                if(num.equals("q")) break;
    
                switch (num) {
                    case "0":
                        System.out.println("Please enter the GoodsID");
                        String ID = scanner.nextLine();
                        goodsMap.get(goodsName).setId(ID);
                        goodsMap.put(goodsName, goodsMap.get(goodsName));
                        break;
                    case "1":
                        System.out.println("Please enter the Goodsname");
                        String GoodName=scanner.nextLine();
                        goodsMap.get(goodsName).setName(GoodName);
                        goodsMap.put(GoodName, goodsMap.get(GoodName));
                        break;
                    case "2":
                        System.out.println("Please enter the manufacturer");
                        String Manu = scanner.nextLine();
                        goodsMap.get(goodsName).setManufacturer(Manu);
                        goodsMap.put(goodsName, goodsMap.get(goodsName));
                        break;
                    case "3":
                        System.out.println("Please enter the price");
                        float price=scanner.nextFloat();
                        String shit=scanner.nextLine();
                        goodsMap.get(goodsName).setPrice(price);
                        goodsMap.put(goodsName, goodsMap.get(goodsName));
                        break;
                    case "4":
                        System.out.println("Please enter the quantity");
                        int quantity =scanner.nextInt();
                        String shit1=scanner.nextLine();
                        goodsMap.get(goodsName).setQuantity(quantity);
                        goodsMap.put(goodsName, goodsMap.get(goodsName));
                        break;

                    default:
                        System.out.println("你看看你，这都能输错");
                        break;
                }
                
                
            }
            System.out.println("Alter success!");
        }
    }
    public void searchGoods(){
        System.out.println("请输入goodsname: ");
        String goodsname=this.scanner.nextLine();
        if(goodsMap.containsKey(goodsname)){
            System.out.println("有该商品的信息");
            System.out.println("the GoodsID: "+goodsMap.get(goodsname).getId());
            System.out.println("the manufacturer: "+goodsMap.get(goodsname).getManufacturer());
            System.out.println("the price: "+goodsMap.get(goodsname).getPrice());
            System.out.println("the quantity: "+goodsMap.get(goodsname).getQuantity());
        }
        else{
            System.out.println("商店没有该商品！");
        }
        

    }
    public void listGoods(){
        if(goodsMap.keySet().isEmpty()){
            System.out.println("没有商品!");
        }
        else{
            System.out.println("即将列出所有商品信息!");
            for (String goodsname : goodsMap.keySet()) {
                // 获取键
                //System.out.println("Key: " + key);
                // 获取对应的值
                System.out.println("the GoodsID: "+goodsMap.get(goodsname).getId());
                System.out.println("the Goodsname"+goodsMap.get(goodsname).getName());
                System.out.println("the manufacturer: "+goodsMap.get(goodsname).getManufacturer());
                System.out.println("the price: "+goodsMap.get(goodsname).getPrice());
                System.out.println("the quantity: "+goodsMap.get(goodsname).getQuantity());
                System.out.println("------------------------------------");
            }
        }
        
        

    }
    public void writeGoodsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Goods.csv",false))) {
          // 写入第一行的标题
           writer.write("Id\tname\tmanufacturer\tprice\tquantity");
           writer.newLine();
        for (String goodsname : goodsMap.keySet()) {
            // 获取键
            //System.out.println("Key: " + key);
            // 获取对应的值
            writer.write(goodsMap.get(goodsname).getId() + "\t" +
                    goodsMap.get(goodsname).getName() + "\t" +
                    goodsMap.get(goodsname).getManufacturer() + "\t" +
                    goodsMap.get(goodsname).getPrice() + "\t" +
                    goodsMap.get(goodsname).getQuantity());
          writer.newLine();
        }
          System.out.println("Goods data written to file successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while writing goods data to file.");
          e.printStackTrace();
        }
      }
    public void readFile(){
        // 指定文件路径
        String filePath = "Goods.csv";

        try {
            // 创建文件对象
            File file = new File(filePath);
            try (// 创建Scanner对象进行文件读取
            Scanner scanner1 = new Scanner(file)) {
                // 读取第一行，包含列名
                String firstLine = scanner1.nextLine();
                // 使用制表符分隔列名
                String[] columnNames = firstLine.split("\t");

                // 读取后续行的数据
                while (scanner1.hasNextLine()) {
                    String line = scanner1.nextLine();
                    // 使用制表符分隔各列数据
                    String[] data = line.split("\t");

                    // 将数据存储到相应的变量中
                    String id = data[0];
                    String name = data[1];
                    String manufacturer = data[2];
                    float price = Float.parseFloat(data[3]);
                    int quantity = Integer.parseInt(data[4]);
                    MyGoods good=new MyGoods(id, name, manufacturer, price, quantity);
                    goodsMap.put(good.getName(), good);
                    
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}