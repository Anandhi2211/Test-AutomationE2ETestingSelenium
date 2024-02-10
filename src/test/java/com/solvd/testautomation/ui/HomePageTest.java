package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.solvd.testautomation.ui.components.MenuOption;
import com.solvd.testautomation.ui.components.SearchComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifySearchTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SearchComponent searchComponent = homePage.getHeader().getSearchComponent();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchComponent.getSearchButton().isElementPresent(2), "Search Button is not present");
        softAssert.assertTrue(searchComponent.getSearchTextArea().isElementPresent(2), "Search Text area is not present");
        searchComponent.typeValueToSearch("Running shoe");
        searchComponent.clickSearchButton();
        softAssert.assertAll();
    }

    @Test
    public void verifyFeatureTab() {
        String productName = "Nike Dunk Low";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2),"New Feature Tab is not Present");
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
        Assert.assertTrue(header.getNewFeature().isElementPresent(2),"New Feature Tab is not Present");
        header.clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.getCategoryOptions().stream()
                .filter(extendedWebElement->extendedWebElement.getText().equalsIgnoreCase(category))
                .forEach(extendedWebElement -> extendedWebElement.click());
    }

    @Test
    public void listOutSaleItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2),"New Feature Tab is not Present");
        header.clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.getItemList()
                .stream()
                .filter(productItem -> productItem.getProductName().getText().equalsIgnoreCase("Nike Dunk Low Retro Premium"))
                .forEach(productItem -> productItem.getProductNameText());
    }

    @Test
    public void verifyJoinUsTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MenuOption menuOption = homePage.getMenuOption();
        Assert.assertTrue(menuOption.getJoinUs().isElementPresent(1),"Join us Tab is not present");
        menuOption.clickJoin();
        SignUpPage signUpPage = new SignUpPage(getDriver());
        Assert.assertTrue(signUpPage.getSignUp().isElementPresent(1),"Sign Up Tab is not present");
        signUpPage.signupClick();
    }

    @Test
    public void verifyHelpTest() {
        HelpPage helpPage = new HelpPage(getDriver());
        helpPage.open();
        String help="shipping";
        Assert.assertTrue(helpPage.searchBox.isElementPresent(1),"Search box in Help page is not Present");
        helpPage.searchBox.type(help);
        Assert.assertTrue(helpPage.searchButton.isElementPresent(1),"Search Button is not present in Help page");
        helpPage.searchButton.click();
    }
}
