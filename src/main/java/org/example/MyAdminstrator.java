package org.example;
import java.util.Scanner;

public class MyAdminstrator implements MyAction {
    private static final String ACTION_NAME = "ad";
    private Scanner scanner = null;
   
    

    public MyAdminstrator() {
        
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
        System.out.print("********欢迎进入管理员菜单********\n");
        System.out.println("请输入管理员的用户ID和密码!");
        // String ID = "";
        // String psw = "";
        // ID=s.nextLine();
        // psw=s.nextLine();
        // System.out.println(ID+"shi1e");
        // System.out.println(psw);
        
         String userInput = "";
         String userInput1="";

        while(true){
            System.out.println("请输入你的指令,q退出,p密码管理,k客户管理,g商品管理");
            System.out.print("你当前在***管理员***二级子目录下 >");
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            if (userInput.equals("g")){
                System.out.println("你现在在**商品管理**三级子菜单下");
                MyGoods good=new MyGoods(scanner);
                while(true){
                    System.out.print("请选择: 1.增加商品 2.删除商品 3.修改商品 4.查询商品 5.列出所有商品 q.退出");
                    userInput1=this.scanner.nextLine();
                    if(userInput1.equals("1")){
                        good.addGoods();
                    }
                    else if(userInput1.equals("2")){
                        good.deltGoods();
                    }
                    else if(userInput1.equals("3")){
                        good.alterGoods();
                    }
                    else if(userInput1.equals("4")){
                        good.readFile();
                        good.searchGoods();
                    }
                    else if(userInput1.equals("5")){
                        good.listGoods();
                    }
                    else if(userInput1.equals("q")){
                        break;
                    }

                }
                good.writeGoodsToFile();
            }

        }

    }
    
    
}
