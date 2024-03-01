//package com.solvd.testautomation.ui;
//
//import com.zebrunner.carina.core.AbstractTest;
//import org.testng.annotations.Test;
//
//public class FactoryTest1 extends AbstractTest {
//    String u;
//    String p;
//
//
//    public FactoryTest1(String type, String username, String password) {
//        if(type.equalsIgnoreCase("customer")){
//            this.u = (username);
//            this.p = password;
//        }
//        else if(type.equalsIgnoreCase("employee")){
//            this.u = (username);
//            this.p = password;
//        }
//    }
//    @Test
//    public void validateCustomerLoginTest() {
//        FactoryLoginValidation validation = new FactoryLoginValidation(getDriver());
//        validation.open();
//        validation.getUsername().click();
//        validation.getUsername().type(u);
//        validation.getPassword().click();
//        validation.getPassword().type(p);
//        validation.getSubmitButton().click();
//    }
//}
//
//
