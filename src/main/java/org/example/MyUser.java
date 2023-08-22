package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyUser implements MyAction {
    private static final String ACTION_NAME = "user";
    private Scanner scanner = null;
    //private Scanner s=new Scanner(System.in);
    

    public MyUser() {
        List<Myfunction> myList=new ArrayList<Myfunction>();
        Mygoods goods=new Mygoods(scanner);
        myList.add(goods);
    }


    public MyUser(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    @Override
    public String getActionName() {
        return MyUser.ACTION_NAME;
    }

    @Override
    public void run(String[] args) {
       DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        databaseInitializer.initializeDatabaseUser();
        Scanner scanner = new Scanner(System.in);
        MypassManager manager=new MypassManager();
        System.out.print("********欢迎进入用户菜单********\n");
        
        System.out.println("请选择注册:register还是登录:login");
        String userInput1 = "";
        userInput1 = this.scanner.nextLine();
        boolean Judge=false;

        MypassLogin login=new MypassLogin(scanner, manager);
        MypassRegister register=new MypassRegister(scanner, manager);
        if(userInput1.equals("register")){
            Judge=register.userRegister();
        }
        else if(userInput1.equals("login")){
            Judge=login.UserLogin();
        }
        
        
        String userInput = "";

        while(Judge){
            System.out.println("请输入你的指令,q退出,p密码管理,g购物车管理");
            System.out.print("你当前在***购物用户***二级子目录下 >");
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            else if (userInput.equals("g")){//购物车管理
                Myfunction good;
                good=new Mygoods();
                good.run(null);
            }
          
            else if(userInput.equals("p")){
                System.out.println("你现在在**修改密码管理**三级菜单下");
                MypassAlter alter=new MypassAlter(scanner, manager);
                alter.alterUserpass();
                
                break;
            }


        }
    }
    
}
