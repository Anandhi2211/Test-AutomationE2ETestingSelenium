package com.solvd.testautomation.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuOption extends AbstractUIObject {
    @FindBy(xpath = ".//a[@data-type='click_navMembership']")
    private ExtendedWebElement joinUs;
    @FindBy(xpath = ".//a[@data-type='click_navStoreLocator']")
    private ExtendedWebElement findStore;
    @FindBy(xpath = ".//div[@id='HelpMenuDropdown']")
    private ExtendedWebElement help;

    public MenuOption(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public ExtendedWebElement getJoinUs() {
        return joinUs;
    }
    public ExtendedWebElement getFindStore() {
        return findStore;
    }

    public ExtendedWebElement getHelp() {
        return help;
    }

    public void clickJoin(){
        joinUs.click();
    }

    public void clickFindStore(){
        findStore.click();
    }
    public void clickGetHelp(){
        help.click();
    }
}
