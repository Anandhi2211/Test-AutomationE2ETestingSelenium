package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.solvd.testautomation.ui.components.MenuOption;
import com.solvd.testautomation.ui.components.ProductItem;
import com.solvd.testautomation.ui.components.SearchComponent;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifyJoinUsTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MenuOption menuOption = homePage.getMenuOption();
        menuOption.getJoinUs().click();
    }

    @Test
    public void verifyHelpTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MenuOption menuOption = homePage.getMenuOption();
        menuOption.getHelp().click();
    }

    @Test
    public void verifyFindStoreTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        MenuOption menuOption = homePage.getMenuOption();
        menuOption.getFindStore().click();
    }

    @Test
    public void verifySearchTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SearchComponent searchComponent = homePage.getHeader().getSearchComponent();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchComponent.getSearchButton().isElementPresent(6),"No present");
        softAssert.assertTrue(searchComponent.getSearchTextArea().isElementPresent(6),"Not Present");
//        searchComponent.typeValueToSearch("Running shoe");
//        searchComponent.clickSearchButton();
//        softAssert.assertAll();
    }
    @Test
    public void verifyFeatureTab(){
        SoftAssert softAssert = new SoftAssert();
        String productName = "Nike Dunk Low";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();

        header.getNewFeature().click();
        FeaturePage featurePage = new FeaturePage(getDriver());
        List<ProductItem> itemList = featurePage.getItemList();
        for(ProductItem item : itemList){
            System.out.println(item.getProductNameText());
            if(item.getProductNameText().equalsIgnoreCase(productName)){
                softAssert.assertTrue(item.getProductNameText().equalsIgnoreCase(productName),"NOT AVAILABLE");
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void clickCategoryOptionTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.getNewFeature().click();
        FeaturePage featurePage = new FeaturePage(getDriver());
        List<ExtendedWebElement> categoryOptions = featurePage.getCategoryOptions();
        for(ExtendedWebElement opt : categoryOptions){
            if(opt.getText().equalsIgnoreCase("shoes")){
                opt.click();
            }
        }
    }

    @Test
    public void listOutSaleItems(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        header.getNewFeature().click();
        FeaturePage featurePage = new FeaturePage(getDriver());
        featurePage.getCheckBox().click();
        List<ProductItem> itemList = featurePage.getItemList();
        for(ProductItem item : itemList){
            System.out.println(item.getTitle());
//            if(item.getProductNameText().equalsIgnoreCase(productName)){
//                softAssert.assertTrue(item.getProductNameText().equalsIgnoreCase(productName),"NOT AVAILABLE");
//            }
        }
    }
}
