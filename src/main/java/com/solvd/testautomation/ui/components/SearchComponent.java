package com.solvd.testautomation.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends AbstractUIObject {
    @FindBy(xpath = "//button[@data-var='vsButton']")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//input[@id='VisualSearchInput']")
    private ExtendedWebElement searchTextArea;

    public SearchComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public ExtendedWebElement getSearchTextArea() {
        return searchTextArea;
    }
    public String getTypeValue(){
        return this.searchTextArea.getAttribute("placeholder");
    }
    public void typeValueToSearch(String value){
        this.searchTextArea.type(value);
    }
    public void clickSearchButton(){
        this.searchButton.click();
    }
}
