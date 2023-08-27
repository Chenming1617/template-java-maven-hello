package org.example;
import java.util.Scanner;

public class MypassUser {
    private Scanner scanner = null;

    private String name;
    private String telephone;
    private double pay;
    private String password;

    public MypassUser() {
    }
    public MypassUser(Scanner scanner){
        this.scanner=scanner;
    }

    public MypassUser(String name, String telephone, double pay, String password) {
        this.name = name;
        this.telephone = telephone;
        this.pay = pay;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
