package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.solvd.testautomation.ui.components.MenuOption;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header")
    private Header header;
    @FindBy(xpath = "//div[@data-pre='DesktopUserMenu']")
    private MenuOption menuOption;
    public MenuOption getMenuOption() {
        return menuOption;
    }
    public Header getHeader() {
        return header;
    }
    public HomePage(WebDriver driver) {
        super(driver);
//        setPageURL("/");
//        setPageAbsoluteURL(Configuration.getRequired("ui_nike_url"));
    }
    @Override
    public void open() {
        openURL(Configuration.getRequired("ui_nike_url"));
    }
}
