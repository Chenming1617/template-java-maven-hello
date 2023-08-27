package org.example;
import java.security.MessageDigest;
import java.util.Scanner;
public class MypassRegister {
    private Scanner scanner = null;
    private MypassManager Manager = null;

    public MypassRegister(Scanner scanner, MypassManager Manager) {
        this.scanner = scanner;
        this.Manager = Manager;
    }
    private static String md5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(input.getBytes());
    
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
    
        return result.toString();
    }
    
    public Boolean userRegister(){
        System.out.println("现在你在用户注册子菜单里.");
        while (true) {
            System.out.print("请输入用户名:");
            String username = this.scanner.nextLine();

            System.out.print("请输入密码:");
            String password = this.scanner.nextLine();

            boolean success = this.Manager.registerUser(username, password);
            
            if (success) {
                System.out.println("success!");
                return success;
            }
        }
    }
    public Boolean admRegister(){
        System.out.println("现在你在管理员注册子菜单里.");
        while (true) {
            System.out.print("请输入用户名:");
            String username = this.scanner.nextLine();

            System.out.print("请输入密码:");
            String password = this.scanner.nextLine();

            boolean success = this.Manager.registerAdm(username, password);
            
            if (success) {
                System.out.println("success!");
                return success;
            }
        }
        
    }
}