package com.solvd.testautomation.ui.components.frames;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Frame2 extends AbstractPage {
    @FindBy(xpath = "//input[@id='firstName']")
    private ExtendedWebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    private ExtendedWebElement lastName;
    @FindBy(xpath = "//input[@id='%srb']")
    private ExtendedWebElement genderOption;
    @FindBy(xpath = "//input[@id='%schbx']")
    private ExtendedWebElement languageKnow;
    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement email;
    public Frame2(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getFirstName() {
        return firstName;
    }
    public ExtendedWebElement getLastName() {
        return lastName;
    }
    public ExtendedWebElement getGenderOption() {
        return genderOption;
    }
    public ExtendedWebElement getLanguageKnow() {
        return languageKnow;
    }
    public ExtendedWebElement getEmail() {
        return email;
    }
    public void typeLastName(String ln) {
        lastName.type(ln);
    }
    public void typeFirstName(String fn) {
        firstName.type(fn);
    }
    public void typeEmail(String emailId) {
        email.type(emailId);
    }
    public void clickFirstname() {
        firstName.click();
    }
    public void clickLastname() {
        lastName.click();
    }
    public void clickGenderOption(String option) {
        genderOption.format(option.toLowerCase()).click();
    }
    public void clickLanguageOption(String language) {
        languageKnow.format(language.toLowerCase()).click();
    }
    public void typeEmailId(String emailId) {
        email.type(emailId);
    }
    public void clickEmail() {
        email.click();
    }
}
