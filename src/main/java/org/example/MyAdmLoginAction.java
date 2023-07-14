package org.example;

import java.util.Scanner;

public class MyAdmLoginAction implements MyBooleanAction {

    private static final String ACTION_NAME = "login";

    private Scanner scanner = null;
    private MyAdmManager userManager = null;

    public MyAdmLoginAction(Scanner scanner, MyAdmManager userManager) {
        this.scanner = scanner;
        this.userManager = userManager;
    }

    @Override
    public String getActionName() {
        return MyAdmLoginAction.ACTION_NAME;
    }

    @Override
    public Boolean run(String[] args) {
        System.out.println("现在你在用户登录子菜单里.");

        while (true) {
            System.out.print("用户名：");
            String username = this.scanner.nextLine();

            System.out.print("密码:");
            String password = this.scanner.nextLine();

            boolean success = this.userManager.login(username, password);

            if (success) {
                System.out.println("success!");
                
                return success;
            } else {
                System.out.println("登录失败，返回上层目录");
                return success;
            }
        }
    }

    public boolean select(){
        System.out.println("现在你在管理员登录子菜单里.");

        while (true) {
            System.out.print("管理员用户名：");
            String username = this.scanner.nextLine();

            System.out.print("密码:");
            String password = this.scanner.nextLine();

            boolean success = this.userManager.login(username, password);

            if (success) {
                System.out.println("登录成功，返回上层目录");
                return success;
                
            } else {
                System.out.println("登录失败，返回上层目录");
                return success;
            }
        }
        
    }
    
}
