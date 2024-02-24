package com.solvd.testautomation.ui.factory;

public class Customer extends Login {
    public String username;
    public String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
}
