package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class MyflieInit {
    public void createGoodsFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Goods.txt"))) {
          writer.write("Id\tname\tmanufacturer\tprice\tquantity");
          writer.newLine();
    
          System.out.println("Goods.txt file created successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while creating the Goods.txt file.");
          e.printStackTrace();
        }
    }
    public void createShopshistoryFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt"))) {
          writer.write("name\tmanufacturer\tpay\tquantity");
          writer.newLine();
    
          System.out.println("History.txt file created successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while creating the History.txt file.");
          e.printStackTrace();
        }
    }
    public void createShopsFile() {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("Shops.txt"))) {
        writer.write("Id\tname\tmanufacturer\tprice\tquantity");
        writer.newLine();
  
        System.out.println("History.txt file created successfully.");
  
      } catch (IOException e) {
        System.out.println("An error occurred while creating the Shops.txt file.");
        e.printStackTrace();
      }
  }
    public void createCustomerFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.txt"))) {
          writer.write("name\ttelephone\ttotalpay\tpassword");
          writer.newLine();
    
          System.out.println("Customer.txt file created successfully.");
    
        } catch (IOException e) {
          System.out.println("An error occurred while creating the Customer.txt file.");
          e.printStackTrace();
        }
    }
    public void createAdmFile() {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("Adminstrator.txt"))) {
        writer.write("name\tpassword");
        writer.newLine();
  
        System.out.println("Adminstrator.txt file created successfully.");
  
      } catch (IOException e) {
        System.out.println("An error occurred while creating the Adminstrator.txt file.");
        e.printStackTrace();
      }
  }
}
