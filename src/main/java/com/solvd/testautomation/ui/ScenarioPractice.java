package com.solvd.testautomation.ui;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScenarioPractice extends AbstractPage {
    @FindBy(xpath = "//select[@name='country']")
    private ExtendedWebElement dropDown;
    @FindBy(xpath = "//select[@name='country']//option")
    private List<ExtendedWebElement> optionList;
    public ScenarioPractice(WebDriver driver) {
        super(driver);
    }
    public void open() {
        openURL(Configuration.getRequired("ui_practice_url"));
    }
    public ExtendedWebElement getDropDown() {
        return dropDown;
    }
    public List<ExtendedWebElement> getOptionList() {
        return optionList;
    }
    public void clickDropDownOption(){
        this.dropDown.click();
    }
}
