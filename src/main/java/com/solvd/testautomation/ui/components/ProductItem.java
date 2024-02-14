package com.solvd.testautomation.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {
//    @FindBy(xpath = "//div[@class='product-card__title']")
    @FindBy(xpath = ".//*[@class='product-card__title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//*[contains(@class,'product-card__hero-image')]")
    private ExtendedWebElement productImg;


    @FindBy(xpath = ".//*[@data-testid='product-card__link-overlay']")
    private ExtendedWebElement link;
    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public ExtendedWebElement getProductName() {
        return productName;
    }
    public String getProductNameText() {
        return productName.getText();
    }
    public void productClick() {
        productName.click();
    }
    public ExtendedWebElement getProductImg() {
        return productImg;
    }
    public ExtendedWebElement getLink() {
        return link;
    }

    public String productText(){
        return productName.getText();
    }
}
