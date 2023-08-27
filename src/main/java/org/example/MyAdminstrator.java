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
        
        Mypassword pass=new Mypassword(scanner);
        String name="";
        pass.readUserFile();
        pass.readAdmFile();
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
                flag=pass.registerAdm(name);
                break;
            }
            else if(Input.equals("login")){
                System.out.println("请输入用户名: ");
                name=scanner.nextLine();
                flag=pass.loginAdm(name);
                break;
            }
        }
         String userInput = "";
         String userInput1="";

        while(flag){
            System.out.println("请输入你的指令,q退出,p密码管理,k客户管理,g商品管理");
            System.out.print("你当前在***管理员***二级子目录下 >");
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            else if(userInput.equals("p")){
                System.out.println("你现在在**密码管理**三级子菜单下");
                pass.alterAdmpass(name);
            }
            else if(userInput.equals("k")){
                System.out.println("你现在在**客户管理**三级子菜单下");
                System.out.println("请选择你的指令:1.修改客户密码 2.列出客户信息");
                String input=scanner.nextLine();
                if(input.equals("1")){
                    System.out.println("请输入客户的用户名");
                    String name1=scanner.nextLine();
                    pass.alterUserpass(name1);
                }
                else if(input.equals("2")){
                    
                    pass.listCustomerinf();
                }

            }
            else if (userInput.equals("g")){
                System.out.println("你现在在**商品管理**三级子菜单下");
                MyGoods good=new MyGoods(scanner);
                good.readFile();
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
