package com.solvd.testautomation.ui;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {
    @FindBy(xpath = "//input[@type='text']")
    private ExtendedWebElement emailTextBox;
    @FindBy(xpath = "//button[@aria-label ='continue']")
    private ExtendedWebElement signUpContinue;
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
    public ExtendedWebElement getSignUpContinue() {
        return signUpContinue;
    }
    public void setEmailTextBox(ExtendedWebElement emailTextBox) {
        this.emailTextBox = emailTextBox;
    }
    public void typeEmail(String email){
        emailTextBox.type(email);
    }
    public void clickSignUpContinue(){
        signUpContinue.click();
    }
}
