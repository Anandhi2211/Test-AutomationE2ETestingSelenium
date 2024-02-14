package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.solvd.testautomation.ui.components.ProductItem;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header")
    private Header header;
    public Header getHeader() {
        return header;
    }
    @FindBy(xpath = "//div[@data-testid='product-card']")
    private List<ProductItem> itemList;
    public List<ProductItem> getItemList() {
        return itemList;
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void open() {
        openURL(Configuration.getRequired("ui_nike_url"));
    }
}
