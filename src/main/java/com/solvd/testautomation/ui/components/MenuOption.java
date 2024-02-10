package com.solvd.testautomation.ui.components;

import com.solvd.testautomation.ui.HelpPage;
import com.zebrunner.carina.utils.IWebElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuOption extends AbstractUIObject {
    @FindBy(xpath = ".//a[@data-type='click_navMembership']")
    private ExtendedWebElement joinUs;
    @FindBy(xpath = ".//div[@id='HelpMenuDropdown']")
    private ExtendedWebElement help;
    public MenuOption(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public ExtendedWebElement getJoinUs() {
        return joinUs;
    }
    public ExtendedWebElement getHelp() {
        return help;
    }
    public void clickJoin(){
        joinUs.click();
    }
    public void clickGetHelp(){
        help.click();
    }
}
