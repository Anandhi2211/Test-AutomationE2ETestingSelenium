package com.solvd.testautomation.ui;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FactoryLoginValidation extends AbstractPage {
    @FindBy(xpath = "//input[@name='username']")
    private ExtendedWebElement username;
    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement password;
    @FindBy(xpath = "//button[@id='submit']")
    private ExtendedWebElement submitButton;

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }
    public ExtendedWebElement getPassword() {
        return password;
    }
    public ExtendedWebElement getUsername() {
        return username;
    }
    public FactoryLoginValidation(WebDriver driver) {
        super(driver);
    }
    @Override
    public void open() {
        openURL(Configuration.getRequired("factory_url"));
    }
}
