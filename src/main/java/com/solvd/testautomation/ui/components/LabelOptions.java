package com.solvd.testautomation.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LabelOptions extends AbstractUIObject {
    @FindBy(xpath = "//ul[@class='_AKr_3ox']//a[@class='JSftBPEZ']")
    List<ExtendedWebElement> labels;
    public LabelOptions(WebDriver driver) {
        super(driver);
    }
    public List<ExtendedWebElement> getLabels() {
        return labels;
    }
}
