package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NikeHomePageTest extends AbstractTest {


    @Test
    public void verifyHelpTest() {
        HelpPage helpPage = new HelpPage(getDriver());
        helpPage.open();
        String help = "shipping";
        Assert.assertTrue(helpPage.getSearchBox().isElementPresent(1), "Search box in Help page is not Present");
        helpPage.typeHelpText(help);
        Assert.assertTrue(helpPage.getSearchButton().isElementPresent(1), "Search Button in help page is not present");
        helpPage.clickHelpButton();
    }

    @Test
    public void verifyFeatureTab() {
        String productName = "Nike Dunk Low";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature Tab in homepage is not Present");
        header.clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.getItemList()
                .stream()
                .filter(productItem -> productItem.getProductNameText().equalsIgnoreCase(productName))
                .forEach(productItem -> productItem.productClick());
    }

    @Test
    public void clickCategoryOptionTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String category = "shoe";
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature Tab in home page is not Present");
        header.clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.getCategoryOptions().stream()
                .filter(extendedWebElement -> extendedWebElement.getText().equalsIgnoreCase(category))
                .forEach(extendedWebElement -> extendedWebElement.click());
    }

    @Test
    public void listOutSaleItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature tab in home page is not present");
        header.clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.getItemList()
                .stream()
                .filter(productItem -> productItem.productText().equalsIgnoreCase("Nike Sweet Swoosh"))
                .forEach(productItem -> productItem.productClick());
    }
}

