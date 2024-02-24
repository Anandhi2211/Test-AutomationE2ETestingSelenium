package com.solvd.testautomation.ui.factory;

public class LoginFactory {

    public String type;

    public static Login getLogin(String type, String username, String password){
        if(type!=null){
            if(type.equals("Customer")){
                return new Customer(username,password);
            }
            else if(type.equals("Employee")){
                return new Employee(username,password);
            }
        }
        return null;
    }
}
