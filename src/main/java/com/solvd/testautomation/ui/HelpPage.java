package com.solvd.testautomation.ui;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='searchInput']")
    public ExtendedWebElement searchBox;
    @FindBy(xpath = "//button[@title='searchIcon']")
    public ExtendedWebElement searchButton;
    public HelpPage(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getSearchBox() {
        return searchBox;
    }
    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }
    public void open() {
        openURL(Configuration.getRequired("ui_nike_help_url"));
    }
    public void typeHelpText(String message){
        searchBox.click();
        searchBox.type(message);
    }
    public void clickHelpButton(){
        searchButton.click();
    }
}
