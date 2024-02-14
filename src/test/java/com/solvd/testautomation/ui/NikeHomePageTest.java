package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NikeHomePageTest extends AbstractTest {

    @DataProvider(name = "validHelpOptions")
    public Object[][] validHelpOptions() {
        return new Object[][]{
                { "shipping"},
                { "Delivery"},
                { "Returns" }
        };
    }

    @Test(description = "Verify Help options",dataProvider = "validHelpOptions")
    public void verifyHelpTest(String options) {
        HelpPage helpPage = new HelpPage(getDriver());
        helpPage.open();
        Assert.assertTrue(helpPage.getSearchBox().isElementPresent(1), "Search box in Help page is not Present");
        Assert.assertTrue(options.matches("^[a-zA-Z&\\s-]+$"),"Options are not in the correct format");
        helpPage.typeHelpText(options);
        Assert.assertTrue(helpPage.getSearchButton().isElementPresent(1), "Search Button in help page is not present");
        helpPage.clickHelpButton();
    }

    @Test
    public void verifyFeatureTab() {
//        String productName = "Nike sweet swoosh";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature Tab in homepage is not Present");
        header.clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        String colorOption = "Black";
        featurePage.clickColorOption(colorOption);
         colorOption = "Pink";
        featurePage.clickColorOption(colorOption);
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
        Assert.assertTrue(category.matches("^[a-zA-Z&\\s-]+$"),"Category name is not in the correct format");
        featurePage.getCategoryOptions().stream()
                .filter(extendedWebElement -> extendedWebElement.getText().equalsIgnoreCase(category))
                .forEach(extendedWebElement -> extendedWebElement.click());
    }

    @Test
    public void listOutSaleItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String shoe = "Air";
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature tab in home page is not present");
        header.clickFeature();
//        FeaturePage featurePage = new FeaturePage(getDriver());
        Assert.assertTrue(shoe.matches("^[a-zA-Z&\\s-]+$"),"shoe name is not in the correct format");
        homePage.getItemList()
                .stream()
                .filter(productItem -> productItem.productText().contains(shoe))
                .forEach(productItem -> System.out.println("ITEM: "+productItem.getProductNameText()));
    }
}

