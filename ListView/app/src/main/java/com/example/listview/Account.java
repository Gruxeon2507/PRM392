package com.example.listview;

public class Account {
    public Account(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  id + "---" + name +"--" + password ;
    }

    private int id;
    private String name,password;
}