package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // MyflieInit init=new MyflieInit();
        // init.createAdmFile();
        // init.createShopsFile();
        // init.createCustomerFile();
        // init.createGoodsFile();
        // init.createShopshistoryFile();
        
        List<MyAction> actionList = new ArrayList<MyAction>();



        MyAdminstrator ad=new MyAdminstrator(scanner);
        actionList.add(ad);
        Myuser user= new Myuser(scanner);
        actionList.add(user);

        String userInput = "";

        while (true) {
            System.out.println("请选择你的指令,ad管理员系统,user用户系统,q退出");
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