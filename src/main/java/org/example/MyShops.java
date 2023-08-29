package org.example;
import java.util.LinkedHashMap;
//import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MyShops {
    private static LinkedHashMap<String, MyShops> shopsMap =new LinkedHashMap<String, MyShops>(); // 用Map来存储商品对象，key为name，value为节点
    private Scanner scanner = null;
    private static LinkedHashMap<String, MyGoods> goodsMap =new LinkedHashMap<String, MyGoods>();
    private String id;
    private String name;
    private String manufacturer;
    private double Price;
    private int quantity;
    public MyShops(Scanner scanner) {
        this.scanner=scanner;
    };

    public MyShops(String id, String name, String manufacturer, double price, int quantity) {
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
    public void readGoodsFile(){//读商品信息Goods文件
        // 指定文件路径
        String filePath = "Goods.txt";

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
    public void listGoods(){//列出商品文件信息
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
    public void addShops(){
       
        System.out.println("请输入shopsname: ");
        String goodsname=scanner.nextLine();
        if(goodsMap.keySet().isEmpty()){
            System.out.println("商店没有商品!");
        }
        else{
            System.out.println("请输入加购数量");
            int num=scanner.nextInt();
            String shit=scanner.nextLine();
            if(num<=goodsMap.get(goodsname).getQuantity()){
                MyShops shop =new MyShops(goodsMap.get(goodsname).getId(),goodsname,goodsMap.get(goodsname).getManufacturer(),goodsMap.get(goodsname).getPrice(),num);
                shopsMap.put(goodsname,shop);
                System.out.println("加购成功!"+shit);

            }
            else{
                System.out.println("你加购的数量超过了商场现有该商品的数量！");
            }
            
        }
        
        System.out.println("添加完成！");
    }
    public void deltShops(){
        System.out.println("请输入shopsName: ");
        String goodsName=this.scanner.nextLine();
        MyShops removegoods = shopsMap.remove(goodsName);
        if (removegoods == null) {
            System.out.println("删除失败，购物车没有该商品");
        } else {
            System.out.println("Have deleted " + removegoods.getName()+" "+removegoods.getName());
        }
    }
    public void alterShops(){
        System.out.println("请输入goodsName: ");
        String goodsName=this.scanner.nextLine();
        if(!goodsMap.containsKey(goodsName)){
            System.out.println("根据商品名找不到该商品");
        }
        else{
            while (true) {
                System.out.println("What do you want to alter,0 ShopsID,1 Shopsname,2 manufacturer,3 price,4 quantity,q exit");
                String num = scanner.nextLine();
                if(num.equals("q")) break;
    
                switch (num) {
                    case "0":
                        System.out.println("Please enter the ShopsID");
                        String ID = scanner.nextLine();
                        shopsMap.get(goodsName).setId(ID);
                        shopsMap.put(goodsName, shopsMap.get(goodsName));
                        break;
                    case "1":
                        System.out.println("Please enter the Goodsname");
                        String GoodName=scanner.nextLine();
                        shopsMap.get(goodsName).setName(GoodName);
                        shopsMap.put(GoodName, shopsMap.get(GoodName));
                        break;
                    case "2":
                        System.out.println("Please enter the manufacturer");
                        String Manu = scanner.nextLine();
                        shopsMap.get(goodsName).setManufacturer(Manu);
                        shopsMap.put(goodsName, shopsMap.get(goodsName));
                        break;
                    case "3":
                        System.out.println("Please enter the price");
                        float price=scanner.nextFloat();
                        String shit=scanner.nextLine();
                        shopsMap.get(goodsName).setPrice(price);
                        shopsMap.put(goodsName, shopsMap.get(goodsName));
                        break;
                    case "4":
                        System.out.println("Please enter the quantity");
                        int quantity =scanner.nextInt();
                        String shit1=scanner.nextLine();
                        shopsMap.get(goodsName).setQuantity(quantity);
                        shopsMap.put(goodsName, shopsMap.get(goodsName));
                        break;

                    default:
                        System.out.println("你看看你，这都能输错");
                        break;
                }
                
                
            }
            System.out.println("Alter success!");
        }
    }
    public void searchShops(){
        System.out.println("请输入shopsname: ");
        String goodsname=this.scanner.nextLine();
        if(shopsMap.containsKey(goodsname)){
            System.out.println("购物车有该商品的信息");
            System.out.println("the shopsID: "+shopsMap.get(goodsname).getId());
            System.out.println("the manufacturer: "+shopsMap.get(goodsname).getManufacturer());
            System.out.println("the price: "+shopsMap.get(goodsname).getPrice());
            System.out.println("the quantity: "+shopsMap.get(goodsname).getQuantity());
        }
        else{
            System.out.println("购物车没有该商品！");
        }
    }
    public void checkShops() throws IOException{
        System.out.println("请输入shopsname: ");
        String shopsname=this.scanner.nextLine();
        if(shopsMap.containsKey(shopsname)){
            System.out.println("购物车有该商品的信息！");
            System.out.println("请输入要购买的数量：");
            int num=this.scanner.nextInt();
            String shit=this.scanner.nextLine();
            if(num<=shopsMap.get(shopsname).quantity){
                double pay=num*shopsMap.get(shopsname).Price;
                shopsMap.get(shopsname).setQuantity(shopsMap.get(shopsname).quantity-num);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt",true))) {
                      writer.write(shopsname + "\t" +
                                shopsMap.get(shopsname).getManufacturer() + "\t" +
                                pay + "\t" +
                                num);
                    writer.newLine();
                    System.out.println("History data written to file successfully."+shit);
                  } catch (IOException e) {
                    System.out.println("An error occurred while writing history data to file.");
                    e.printStackTrace();
                  }
            }
            else {
                System.out.println("购买的数量超过了购物车中该商品的数量");
            }
        }
        else{
            System.out.println("购物车中没有该商品");
        }
    }
    public void listShopsHistroy(){
        String filePath = "History.txt";

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
                    String name = data[0];
                    String manufacturer = data[1];
                    float pay = Float.parseFloat(data[2]);
                    int quantity = Integer.parseInt(data[3]);
                    System.out.println("the Goodsname"+name);
                    System.out.println("the manufacturer: "+manufacturer);
                    System.out.println("the totalpay: "+pay);
                    System.out.println("the quantity: "+quantity);
                    System.out.println("------------------------------------");
                }
            } catch (NumberFormatException e) {
                
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
    }

    public void readShopsFile(){
        // 指定文件路径
        String filePath = "Shops.txt";

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
                    MyShops shop=new MyShops(id, name, manufacturer, price, quantity);
                    shopsMap.put(shop.getName(), shop);
                    
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeShopsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Shops.txt",false))) {
          // 写入第一行的标题
           writer.write("Id\tname\tmanufacturer\tprice\tquantity");
           writer.newLine();
        for (String shopsname : shopsMap.keySet()) {
            // 获取键
            //System.out.println("Key: " + key);
            // 获取对应的值
            writer.write(shopsMap.get(shopsname).getId() + "\t" +
                    shopsMap.get(shopsname).getName() + "\t" +
                    shopsMap.get(shopsname).getManufacturer() + "\t" +
                    shopsMap.get(shopsname).getPrice() + "\t" +
                    shopsMap.get(shopsname).getQuantity());
          writer.newLine();
        }
          System.out.println("Shops data written to file successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while writing goods data to file.");
          e.printStackTrace();
        }
      }

}
