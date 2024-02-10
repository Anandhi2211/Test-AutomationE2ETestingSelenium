package com.solvd.testautomation.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//header//*[@class='pt1-lg']//a[@aria-label='New & Featured']")
    private ExtendedWebElement newFeature;
    @FindBy(xpath = "//header//*[@class='pt1-lg']//a[@aria-label='Men']")
    private ExtendedWebElement men;
    @FindBy(xpath = "//header//*[@class='pt1-lg']//a[@aria-label='Women']")
    private ExtendedWebElement women;
    @FindBy(xpath = ".//div[@type='search']")
    private SearchComponent searchComponent;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
    public ExtendedWebElement getNewFeature() {
        return newFeature;
    }
    public ExtendedWebElement getMen() {
        return men;
    }
    public ExtendedWebElement getWomen() {
        return women;
    }
    public void clickFeature(){
        newFeature.click();
    }
}
