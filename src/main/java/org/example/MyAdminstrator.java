package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAdminstrator implements MyAction {
    private static final String ACTION_NAME = "ad";
    private Scanner scanner = null;
    private Scanner s=new Scanner(System.in);
    

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
        System.out.print("********欢迎进入管理员菜单********\n");
        System.out.println("请输入管理员的用户ID和密码!");
        String ID = "";
        String psw = "";
        ID=s.nextLine();
        psw=s.nextLine();
        System.out.println(ID+"shi1e");
        System.out.println(psw);
        
        String userInput = "";

        while(true){
            System.out.println("请输入你的指令,q退出,p密码管理,k客户管理,g商品管理");
            System.out.print("你当前在***管理员***二级子目录下 >");
            userInput = this.scanner.nextLine();
            if (userInput.equals("q")) {
                break;
            }
            if (userInput.equals("g")){
                Myfunction A;
                A=new Mygoods();
                A.run(null);
            }

            

        }




    }
    
    
}
