package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.ProductItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FeaturePage extends AbstractPage {


    public List<ExtendedWebElement> getCategoryOptions() {
        return categoryOptions;
    }

    public ExtendedWebElement getCheckBox() {
        return checkBox;
    }

    @FindBy(xpath = "//button[contains(@aria-label,'Extra 20%')]//div[contains(@class,'css-18pl6ws')]")
    private ExtendedWebElement checkBox;

    @FindBy(xpath = "//div[@class='categories__content']//a[@data-group-type='category']")
    private List<ExtendedWebElement> categoryOptions;
    @FindBy(xpath = "//div[@class='product-card__body']")
    private List<ProductItem> itemList;
    public FeaturePage(WebDriver driver) {
        super(driver);
    }

    public List<ProductItem> getItemList() {
        return itemList;
    }
}
