package org.example;
import java.util.Scanner;
public class MyPasswordManagement implements MyAction  {
    private static final String ACTION_NAME = "Password";
    private Scanner scanner = null;

    public MyPasswordManagement(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getActionName() {
        return MyPasswordManagement.ACTION_NAME;
    }

    @Override
    public void run(String[] args) {
        
        
    }

    
    
}
