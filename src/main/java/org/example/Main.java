package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("********欢迎进入购物车管理系统********");

        Scanner scanner = new Scanner(System.in);

        List<MyAction> actionList = new ArrayList<MyAction>();
        MyHelpAction help = new MyHelpAction(scanner);
        actionList.add(help);

        MyAdminstrator ad=new MyAdminstrator(scanner);
        actionList.add(ad);

        MyAboutAction about = new MyAboutAction(scanner);
        actionList.add(about);
        
        String userInput = "";

        while (true) {
            System.out.println("请选择你的指令,ad管理员系统,user用户系统,exit退出");
            System.out.print("你当前在第一级目录下 >");
            userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
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