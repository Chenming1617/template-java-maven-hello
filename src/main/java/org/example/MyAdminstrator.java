package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAdminstrator implements MyAction {
    private static final String ACTION_NAME = "ad";
    private Scanner scanner = null;
    //private Scanner s=new Scanner(System.in);
    

    public MyAdminstrator() {
        List<Myfunction> myList=new ArrayList<Myfunction>();
        Mygoods goods=new Mygoods(scanner);
        myList.add(goods);
    }


    public MyAdminstrator(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    @Override
    public String getActionName() {
        return MyAdminstrator.ACTION_NAME;
    }

    @Override
    public void run(String[] args) {
       //DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        //databaseInitializer.initializeDatabaseAdm();//创建一次就行了，后面注释掉
        Scanner scanner = new Scanner(System.in);
        MypassManager manager=new MypassManager();
        System.out.print("********欢迎进入管理员菜单********\n");
        
        System.out.println("请选择注册:register还是登录:login");
        String userInput1 = "";
        userInput1 = this.scanner.nextLine();
        boolean Judge=false;

        MypassLogin login=new MypassLogin(scanner, manager);
        MypassRegister register=new MypassRegister(scanner, manager);
        if(userInput1.equals("register")){
            Judge=register.admRegister();
        }
        else if(userInput1.equals("login")){
            Judge=login.AmdLogin();
        }
        
        
        String userInput = "";
        

        while(Judge){
            System.out.println("请输入你的指令,q退出,p密码管理,k客户管理,g商品管理");
            System.out.print("你当前在***管理员***二级子目录下 >");
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            else if (userInput.equals("g")){//商品管理
                while(true){
                    System.out.println("你现在在**商品管理**三级菜单下");
                    
                    MygoodManager good =new MygoodManager(scanner);
                    System.out.print("请选择: a.列出所有商品信息b.增加商品信息c.删除商品信息d.修改商品信息e.查找商品信息q.退出");
                    
                    String userInput2 = this.scanner.nextLine();
                    if (userInput2.equals("a")) {
                        System.out.println("还没实现！");
            
                    }
                    else if(userInput2.equals("b")){
                        good.addGoods();
                    }
                    else if(userInput2.equals("c")){
                        good.deleteGoods();
                    }
                    else if(userInput2.equals("d")){
                        good.alterGoods();
                    }
                    else if(userInput2.equals("e")){
                        good.SearchGoods();
                    }
                    else if(userInput2.equals("q")){
                        break;
                    }
                }
            }
            else if(userInput.equals("p")){
                System.out.println("你现在在**修改密码管理**三级菜单下");
                MypassAlter alter=new MypassAlter(scanner, manager);
                alter.alterAdmpass();
                break;
            }
            else if(userInput.equals("k")){
                while(true){
                    System.out.println("你现在在**客户管理**三级菜单下");
                    
                    MypassAlter alter =new MypassAlter(scanner,manager);
                    System.out.print("请选择：a.列出所有用户信息b.根据用户名删除用户信息c.根据用户名查询用户信息q.退出");
                    
                    String userInput2 = this.scanner.nextLine();
                    if (userInput2.equals("a")) {
                        alter.listUserinf();
                    }
                    else if(userInput2.equals("b")){
                        alter.deltUserinf();
                    }
                    else if(userInput2.equals("c")){
                        alter.searchUserinf();
                    }
                    else if(userInput2.equals("q")){
                        break;
                    }
                }
            }
            


        }
    }
    
    
}
