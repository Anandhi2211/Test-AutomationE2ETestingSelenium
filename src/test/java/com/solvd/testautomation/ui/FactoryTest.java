package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.factory.LoginFactory;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.support.Color;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactoryTest extends AbstractTest {
    @DataProvider(name = "testData")
    public Object[][] validSearchOptions() {
        return new Object[][]{
                {"Customer", "student", "Password123"},
                {"Employee", "student", "Password123"}
        };
    }

    @Test(dataProvider = "testData")
    public void validateCustomerLoginTest(String type, String username, String password) {
        FactoryLoginValidation validation = new FactoryLoginValidation(getDriver());
        validation.open();
        validation.getUsername().click();
        validation.getUsername().type(LoginFactory.getLogin(type, username, password).getUsername());
        validation.getPassword().click();
        validation.getPassword().type(LoginFactory.getLogin(type, username, password).getPassword());
        validation.getSubmitButton().click();
    }
    @Test
    public void colorValidationTest(){
        FactoryLoginValidation validation = new FactoryLoginValidation(getDriver());
        validation.open();
        String color = validation.getSubmitButton().getElement().getCssValue("color");
        String color1 = Color.fromString(color).asHex();
        System.out.println("color"+color);
        System.out.println("color1"+color1);
        //Assert statements
    }


}
