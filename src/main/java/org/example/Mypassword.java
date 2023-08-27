package org.example;
import java.util.LinkedHashMap;
//import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Mypassword {
    private static LinkedHashMap<String, MypassAdm> admMap =new LinkedHashMap<String, MypassAdm>();
    private static LinkedHashMap<String, MypassUser> userMap =new LinkedHashMap<String, MypassUser>();
    
    private Scanner scanner = null;
    public Mypassword() {
        
    }
    public Mypassword(Scanner scanner) {
        this.scanner = scanner;
    }

    public Boolean registerAdm(){
        //MypassAdm adm=new MypassAdm();
        System.out.println("请输入注册用户名：");
        String name=scanner.nextLine();
        if(admMap.containsKey(name)){
            System.out.println("注册失败，该用户名已经用过");
            return false;
        }
        else{
            System.out.println("请输入密码：");
            String password=scanner.nextLine();
            MypassAdm adm=new MypassAdm(name,password);
            admMap.put(name,adm);
            System.out.println("管理员注册成功！");
            return true;
        }
    }
    public Boolean registerUser(){
        System.out.println("请输入注册用户名：");
        String name=scanner.nextLine();
        if(userMap.containsKey(name)){
            System.out.println("注册失败，该用户名已经用过");
            return false;
        }
        else{
            System.out.println("请输入密码：");
            String password=scanner.nextLine();
            System.out.println("请输入电话号码：");
            String telephone=scanner.nextLine();
            double pay =0.;
            MypassUser user=new MypassUser(name,telephone,pay,password);
            userMap.put(name,user);
            System.out.println("用户注册成功！");
            return true;
        }

    }
    public Boolean loginAdm(){
        System.out.println("请输入用户名: ");
        String name=scanner.nextLine();
        if(admMap.containsKey(name)){
            while(true){
            int flag=4;
            System.out.println("请输入密码: ");
            String password=scanner.nextLine();
            if(admMap.get(name).getPassword().equals(password)){
                System.out.println("登录成功！");
                return true;
            }
            else{
                if(flag<=0){
                    return false;
                }
                System.out.println("密码输入错误！你还有"+flag+"次机会，否则账户锁定！");
                flag=flag-1;

            }
            }  
        }
        else{
            System.out.println("用户名不存在！");
            return false;
        }

    }
    public Boolean loginUser(){
        System.out.println("请输入用户名: ");
        String name=scanner.nextLine();
        if(userMap.containsKey(name)){
            while(true){
            int flag=4;
            System.out.println("请输入密码: ");
            String password=scanner.nextLine();
            if(userMap.get(name).getPassword().equals(password)){
                System.out.println("登录成功！");
                return true;
            }
            else{
                if(flag<=0)return false;
                System.out.println("密码输入错误！你还有"+flag+"次机会，否则账户锁定！");
                flag=flag-1;

            }
            }  
        }
        else{
            System.out.println("用户名不存在！");
            return false;
        }
    }
    public void alterUserpass(String name){
        System.out.println("请输入新密码: ");
        String newpassword=scanner.nextLine();
        userMap.get(name).setPassword(newpassword);
        System.out.println("修改成功!");

    }
    public void alterAdmpass(String name){
        System.out.println("请输入新密码: ");
        String newpassword=scanner.nextLine();
        admMap.get(name).setPassword(newpassword);
        System.out.println("修改成功!");

    }
    public void listCustomerinf(){
        if(userMap.keySet().isEmpty()){
            System.out.println("没有顾客信息!");
        }
        else{
            System.out.println("即将列出所有顾客信息!");
            for (String name : userMap.keySet()) {
                // 获取键
                //System.out.println("Key: " + key);
                // 获取对应的值
                System.out.println("the UserName: "+userMap.get(name).getName());
                System.out.println("the Telephone"+userMap.get(name).getTelephone());
                System.out.println("the Totalpay: "+userMap.get(name).getPay());
                System.out.println("------------------------------------");
            }
        }

    }
    public void writeUserToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.txt",true))) {
            for (String name : userMap.keySet()) {
                // 获取键
                //System.out.println("Key: " + key);
                // 获取对应的值
              writer.write(userMap.get(name).getName()+ "\t" +
                            userMap.get(name).getTelephone()+ "\t" +
                            userMap.get(name).getPay()+ "\t" +
                            userMap.get(name).getPassword());
              writer.newLine();
            }
              System.out.println("Customer data written to file successfully.");
        
            } catch (IOException e) {
              System.out.println("An error occurred while writing Customer data to file.");
              e.printStackTrace();
            }

    }
    public void writeAdmToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Adminstrator.txt",true))) {
          for (String name : admMap.keySet()) {
              // 获取键
              //System.out.println("Key: " + key);
              // 获取对应的值
            writer.write(admMap.get(name).getName()+ "\t" +
                           admMap.get(name).getPassword());
            writer.newLine();
          }
            System.out.println("Adminstrator data written to file successfully.");
      
          } catch (IOException e) {
            System.out.println("An error occurred while writing Adminstrator data to file.");
            e.printStackTrace();
          }
    }
    public void readAdmFile(){
         // 指定文件路径
         String filePath = "Adminstrator.txt";

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
                     String password = data[1];
                     
                     MypassAdm adm=new MypassAdm(name, password);
                     admMap.put(adm.getName(), adm);
                     
                 }
             } catch (NumberFormatException e) {
                 e.printStackTrace();
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
    }
    public void readUserFile(){
         // 指定文件路径
         String filePath = "Customer.txt";

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
                     String telephone = data[1];
                     String password = data[3];
                     double pay = Double.parseDouble(data[2]);
                     MypassUser user=new MypassUser(name, telephone,pay,password);
                     userMap.put(user.getName(), user);
                     
                 }
             } catch (NumberFormatException e) {
                 e.printStackTrace();
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
    }
    
}
