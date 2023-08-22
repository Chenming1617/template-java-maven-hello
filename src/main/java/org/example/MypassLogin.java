package org.example;

import java.util.Scanner;

public class MypassLogin{
    private Scanner scanner = null;
    private MypassManager Manager = null;

    public MypassLogin(Scanner scanner, MypassManager Manager) {
        this.scanner = scanner;
        this.Manager = Manager;
    }
    public Boolean UserLogin(){
        System.out.println("现在你在用户登录子菜单里.");

        while (true) {
            System.out.print("用户名：");
            String username = this.scanner.nextLine();

            System.out.print("密码:");
            String password = this.scanner.nextLine();

            boolean success = this.Manager.loginUser(username, password);

            if (success) {
                System.out.println("success!");
                
                return success;
            } else {
                System.out.println("登录失败，返回上层目录");
                return success;
            }
        }

    } 
    public Boolean AmdLogin(){
        System.out.println("现在你在Amd登录子菜单里.");

        while (true) {
            System.out.print("用户名：");
            String username = this.scanner.nextLine();

            System.out.print("密码:");
            String password = this.scanner.nextLine();

            boolean success = this.Manager.loginAdm(username, password);

            if (success) {
                System.out.println("success!");
                
                return success;
            } else {
                System.out.println("登录失败，返回上层目录");
                return success;
            }
        }
    }
}