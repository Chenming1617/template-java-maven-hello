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
        //databaseInitializer.initializeDatabaseAdm();

        MyAdmManager userManager = new MyAdmManager();
        
        Scanner scanner = new Scanner(System.in);
        List<MyBooleanAction> actionList = new ArrayList<MyBooleanAction>();
        MyAdmRegisterAction userRegister = new MyAdmRegisterAction(scanner, userManager);
        actionList.add(userRegister);
        MyAdmLoginAction userLogin = new MyAdmLoginAction(scanner, userManager);
        actionList.add(userLogin);
        System.out.print("********欢迎进入管理员菜单********\n");
        
        System.out.println("请选择注册:register还是登录:login");
        String userInput1 = "";
        userInput1 = this.scanner.nextLine();
        String actionName = null;
        boolean Judge=false;

        for(MyBooleanAction oneAction: actionList) {
            actionName = oneAction.getActionName();

            if (userInput1.equalsIgnoreCase(actionName)) {
                Judge=oneAction.run(null);
            }
        }
        
        
        String userInput = "";

        while(Judge){
            System.out.println("请输入你的指令,q退出,p密码管理,k客户管理,g商品管理");
            System.out.print("你当前在***管理员***二级子目录下 >");
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            else if (userInput.equals("g")){
                Myfunction good;
                good=new Mygoods();
                good.run(null);
            }
            else if(userInput.equals("k")){
                break;

            }
            else if(userInput.equals("p")){
                break;
            }


        }
    }
    
    
}
