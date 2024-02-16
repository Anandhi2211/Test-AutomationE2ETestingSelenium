package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.headercomponenets.SearchComponent;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.URL;


public class SearchTest extends AbstractTest {

    @DataProvider(name = "validSearchOptions")
    public Object[][] validSearchOptions() {
        return new Object[][]{
                {"Running shoe"}
        };
    }


    //updated 1. task
    @Test(description = "Verify Search options", dataProvider = "validSearchOptions")
    public void verifySearchTest(String options) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SearchComponent searchComponent = homePage.getHeader().getSearchComponent();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchComponent.getSearchButton().isElementPresent(2), "Search Button is not present");
        softAssert.assertTrue(searchComponent.getSearchTextArea().isElementPresent(2), "Search Text area is not present");
        searchComponent.clickSearchTestArea();
        Assert.assertTrue(options.matches("^[a-zA-Z&\\s-]+$"), "Search Options are not in the correct format");
        searchComponent.typeValueToSearch(options);
        searchComponent.clickSearchButton();
        homePage.getItemList().stream()
                .forEach(productItem -> {
                            Assert.assertTrue(productItem.getRootExtendedElement().getAttribute("data-testid").contains("product-card"), "Product WebElement Doesn't match");
                            Assert.assertTrue(productItem.getProductName().getAttribute("class").contains("product-card"), "Product Title WebElement Doesn't match");
                            Assert.assertTrue(productItem.getProductImg().getAttribute("class").contains("product-card"), "Product Title WebElement Doesn't match");
                            Assert.assertTrue(productItem.getLink().getAttribute("data-testid").contains("product-card"), "Product Link Web element doenst Match");
                            Assert.assertTrue(checkUrlLink(productItem.getLink().getAttribute("href")), "Link Broken");
                        }
                );
        softAssert.assertAll();
    }
    private boolean checkUrlLink(String productLink) {
        boolean flag = false;
        try {
            URL link = new URL(productLink);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            System.out.println(productLink + " - " + "is a broken link");
        }
        return flag;
    }
}
