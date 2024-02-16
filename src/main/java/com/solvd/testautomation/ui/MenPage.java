package com.solvd.testautomation.ui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenPage extends AbstractPage {
    public MenPage(WebDriver driver) {
        super(driver);
    }
    public List<ExtendedWebElement> getLabels() {
        return labels;
    }
    @FindBy(xpath = "//ul[@class='_AKr_3ox']//a[@class='JSftBPEZ']")
    List<ExtendedWebElement> labels;

}
