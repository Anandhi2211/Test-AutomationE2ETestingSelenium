package com.solvd.testautomation.ui;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FrameHomePage extends AbstractPage {
    @FindBy(xpath = "//iframe[@id='frm1']")
    private ExtendedWebElement frame1;
    @FindBy(xpath = "//iframe[@id='frm2']")
    private ExtendedWebElement frame2;
    public FrameHomePage(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getFrame1() {
        return frame1;
    }
    public ExtendedWebElement getFrame2() {
        return frame2;
    }
    public void open() {
        openURL(Configuration.getRequired("frame_url"));
    }

}
