package com.solvd.testautomation.ui;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='JSftBPEZ']")
    public ExtendedWebElement signUp;

    public ExtendedWebElement getSignUp() {
        return signUp;
    }

    public void signupClick(){
        signUp.click();
    }
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openURL(Configuration.getRequired("ui_nike_signup_url"));
    }

}
