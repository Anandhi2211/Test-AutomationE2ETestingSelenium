package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.SearchComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends AbstractTest {

    @DataProvider(name = "validSearchOptions")
    public Object[][] validSearchOptions() {
        return new Object[][]{
                { "Casual Shoe"},
                { "Running shoe"}
        };
    }

    @Test(description = "Verify Search options",dataProvider = "validSearchOptions")
    public void verifySearchTest(String options) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SearchComponent searchComponent = homePage.getHeader().getSearchComponent();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchComponent.getSearchButton().isElementPresent(2), "Search Button is not present");
        softAssert.assertTrue(searchComponent.getSearchTextArea().isElementPresent(2), "Search Text area is not present");
        searchComponent.clickSearchTestArea();
        searchComponent.typeValueToSearch(options);
        searchComponent.clickSearchButton();
        softAssert.assertAll();
    }
}
