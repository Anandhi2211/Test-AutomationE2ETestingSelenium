package com.solvd.testautomation.ui.components.headercomponenets;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutoSuggest extends AbstractUIObject {
    @FindBy(xpath = ".//a[contains(@id,'VisualSearchSuggestion')]")
    private List<ExtendedWebElement> autoSuggestionListName;
    public AutoSuggest(WebDriver driver) {
        super(driver);
    }
    public List<ExtendedWebElement> getAutoSuggestionListName() {
        return autoSuggestionListName;
    }
}
