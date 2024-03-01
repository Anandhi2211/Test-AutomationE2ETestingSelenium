package com.solvd.testautomation.ui.factory;

public class Employee extends Login {
    public String username;
    public String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(String username, String password) {
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
