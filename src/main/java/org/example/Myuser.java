package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Myuser implements MyAction {
    private static final String ACTION_NAME = "user";
    private Scanner scanner = null;
   
    

    public Myuser() {
        
    }


    public Myuser(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    @Override
    public String getActionName() {
        return Myuser.ACTION_NAME;
    }

    @Override
    public void run(String[] args) {
        System.out.print("********欢迎进入用户菜单********\n");
        Mypassword pass=new Mypassword(scanner);
        String name="";
        pass.readUserFile();
        Boolean flag=false;
        while(true){
            System.out.println("请输入你的指令,login:登录 register:注册 q:退出");
            String Input=scanner.nextLine();
            if(Input.equals("q")){
                break;
            }
            if(Input.equals("register")){
                System.out.println("请输入注册用户名：");
                name=scanner.nextLine();
                flag=pass.registerUser(name);
                break;
            }
            else if(Input.equals("login")){
                System.out.println("请输入用户名: ");
                name=scanner.nextLine();
                flag=pass.loginUser(name);
                break;
            }
        }
        
        
         String userInput = "";
         String userInput1="";

        while(flag){
            System.out.print("你当前在***用户***二级子目录下 >");
            System.out.println("请输入你的指令,q退出,p密码管理,g购物管理");
            
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            else if(userInput.equals("p")){
                System.out.println("你现在在****密码管理三级子菜单下");
                pass.alterUserpass(name);
            }
            else if (userInput.equals("g")){
                 MyShops shop=new MyShops(scanner);
                 while(true){
                    System.out.println("你现在在**购物管理**三级子菜单下");
                    System.out.print("请选择: 1.列出可购商品 2.添加商品到购物车 3.删除购物车信息 4.修改购物车信息 5.查询购物车信息 6.模拟结账 7.查看购物历史 q.退出");
                    userInput1=this.scanner.nextLine();
                    shop.readGoodsFile();
                    shop.readShopsFile();

                    if(userInput1.equals("1")){
                        shop.listGoods();
                    }
                    else if(userInput1.equals("2")){
                        shop.addShops();
                    }
                    else if(userInput1.equals("3")){
                        shop.deltShops();     
                    }
                    else if(userInput1.equals("4")){
                        shop.alterShops();
                    }
                    else if(userInput1.equals("5")){
                       
                       shop.searchShops();
                    }
                    else if(userInput1.equals("6")){
                       try {
                        shop.checkShops();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    }
                    else if(userInput1.equals("7")){
                       shop.listShopsHistroy();
                    }
                    else if(userInput1.equals("q")){
                        break;
                    }

                }
                shop.writeShopsToFile();
            }

        }
        
    }
    
}
