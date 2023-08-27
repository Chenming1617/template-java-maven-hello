package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class MyflieInit {
    public void createGoodsFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Goods.csv"))) {
          writer.write("Id\tname\tmanufacturer\tprice\tquantity");
          writer.newLine();
    
          System.out.println("Goods.csv file created successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while creating the Goods.csv file.");
          e.printStackTrace();
        }
    }
    public void createShopshistoryFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.csv"))) {
          writer.write("name\tmanufacturer\tpay\tquantity");
          writer.newLine();
    
          System.out.println("History.csv file created successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while creating the History.csv file.");
          e.printStackTrace();
        }
    }
    public void createShopsFile() {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("Shops.csv"))) {
        writer.write("Id\tname\tmanufacturer\tprice\tquantity");
        writer.newLine();
  
        System.out.println("History.csv file created successfully.");
  
      } catch (IOException e) {
        System.out.println("An error occurred while creating the Shops.csv file.");
        e.printStackTrace();
      }
  }
    public void createCustomerFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.csv"))) {
          writer.write("name\ttelephone\ttotalpay\tpassword");
          writer.newLine();
    
          System.out.println("Customer.csv file created successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while creating the Customer.csv file.");
          e.printStackTrace();
        }
    }
    public void createAdmFile() {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("Adminstrator.csv"))) {
        writer.write("name\tpassword");
        writer.newLine();
  
        System.out.println("Adminstrator.csv file created successfully.");
  
      } catch (IOException e) {
        System.out.println("An error occurred while creating the Adminstrator.csv file.");
        e.printStackTrace();
      }
  }
}
