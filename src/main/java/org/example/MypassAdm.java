package org.example;

import java.util.Scanner;

public class MypassAdm {
    private Scanner scanner = null;
    private String name;
    private String password;

    public MypassAdm() {
    }

    public MypassAdm(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}