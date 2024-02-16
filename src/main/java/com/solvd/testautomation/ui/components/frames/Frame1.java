package com.solvd.testautomation.ui.components.frames;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Frame1 extends AbstractPage {
    @FindBy(xpath = "//select[@id='selectnav2']")
    private ExtendedWebElement dropDownBox;
    public Frame1(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getDropDownBox() {
        return dropDownBox;
    }
    public void clickDropDownBox(){
        dropDownBox.click();
    }
}
