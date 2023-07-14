package org.example;

import java.util.Scanner;

public class MyAdmRegisterAction implements MyBooleanAction {

    private static final String ACTION_NAME = "register";

    private Scanner scanner = null;
    private MyAdmManager userManager = null;

    public MyAdmRegisterAction(Scanner scanner, MyAdmManager userManager) {
        this.scanner = scanner;
        this.userManager = userManager;
    }

    @Override
    public String getActionName() {
        return MyAdmRegisterAction.ACTION_NAME;
    }

    @Override
    public Boolean run (String[] args) {
        System.out.println("现在你在管理员注册子菜单里.");
        while (true) {
            System.out.print("请输入用户名:");
            String username = this.scanner.nextLine();

            System.out.print("请输入密码:");
            String password = this.scanner.nextLine();

            boolean success = this.userManager.registerAdm(username, password);
            
            if (success) {
                System.out.println("success!");
                return success;
            }
        }
        
    }
    
}

