package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        databaseInitializer.initializeDatabase();
        databaseInitializer.initializeDatabase1();

       // MyUserManager userManager = new MyUserManager();
        
        Scanner scanner = new Scanner(System.in);

        List<MyAction> actionList = new ArrayList<MyAction>();
        
        MyAdminstrator ad=new MyAdminstrator(scanner);
        actionList.add(ad);

       // MyUserRegisterAction userRegister = new MyUserRegisterAction(scanner, userManager);
        //actionList.add(userRegister);

        //MyUserLoginAction userLogin = new MyUserLoginAction(scanner, userManager);
       // actionList.add(userLogin);

        String userInput = "";

        while (true) {
            System.out.println("请选择你的指令,q退出,ad管理员系统,user用户系统");
            System.out.print("你当前在第一级目录下 >");
            userInput = scanner.nextLine();

            if (userInput.equals("q")) {
                break;
            }
            
            String actionName = null;
            for(MyAction oneAction: actionList) {
                actionName = oneAction.getActionName();

                if (userInput.equalsIgnoreCase(actionName)) {
                    oneAction.run(null);
                }
            }

        }

        scanner.close();
        System.out.println("Done.");
    }
}