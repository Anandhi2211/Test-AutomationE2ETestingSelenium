package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.headercomponenets.MenuOption;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JoinUsPageTest extends AbstractTest {

    @DataProvider(name = "validEmailId")
    public Object[][] validEmailId() {
        return new Object[][]{
                { "anandhirmk@gmail.com"},
                { "anandhirmkcse@gmail.com"}
        };
    }

    @Test(description = "verify Join Us Page",dataProvider = "validEmailId")
    public void verifyJoinUsTest(String email) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MenuOption menuOption = homePage.getHeader().getMenuOption();
        Assert.assertTrue(menuOption.getJoinUs().isElementPresent(1), "Join us Tab is not present");
        menuOption.clickJoin();
        SignUpPage signUpPage = new SignUpPage(getDriver());
        Assert.assertTrue(signUpPage.getSignUp().isElementPresent(1), "Sign Up Tab is not present");
        signUpPage.signupClick();
        Assert.assertTrue(email.matches("^[a-zA-Z@.&\\s-]+$"),"Email is not as in expected format");
        signUpPage.typeEmail(email);
        signUpPage.clickSignUpContinue();
    }
}
