package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Header;
import com.solvd.testautomation.ui.components.headercomponenets.AutoSuggest;
import com.solvd.testautomation.ui.listener.MyListener;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners({MyListener.class})
public class NikeHomePageTest extends AbstractTest {

    @DataProvider(name = "validHelpOptions")
    public Object[][] validHelpOptions() {
        return new Object[][]{
                {"exchange"}
        };
    }

    @Test//6. Task
    public void autoSuggestion() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String option = "dunk";
        Assert.assertTrue(homePage.getHeader().getSearchComponent().getSearchTextArea().isElementPresent(2), "Search Text Area element is not present");
        homePage.getHeader().getSearchComponent().clickSearchTestArea();
        Assert.assertTrue(option.matches("^[a-zA-Z\\s-]+$"), "Options are not in the expected format");
        homePage.getHeader().getSearchComponent().typeValueToSearch(option);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@id,'VisualSearchSuggestion')]")));
        AutoSuggest autoSuggest = new AutoSuggest(homePage.getDriver());
        autoSuggest.getAutoSuggestionListName().stream()
                .forEach(extendedWebElement ->
                {
                    Assert.assertTrue(extendedWebElement.getAttribute("data-display-text").contains(option), "Given Search word is not in the suggested Options");
//                    System.out.println("list"+extendedWebElement.getAttribute("data-display-text"));
                });
    }

    @Test//2. Task
    public void verifyFeatureTab() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature Tab in homepage is not Present");
        homePage.getHeader().clickFeature();
        FeaturePage featurePage = new FeaturePage(getDriver());
        String colorOption = "Pink";
        Assert.assertFalse(colorOption.isBlank(), "Color options is Empty");
        Assert.assertTrue(colorOption.matches("^[a-zA-Z&\\s-]+$"), "Give color options is not in a given format");
        featurePage.clickColorOption(colorOption);
        homePage.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @Test//4. Task
    public void clickFeatureOpensNewTab() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        getDriver().manage().window().maximize();
        Assert.assertTrue(homePage.getHeader().getNewFeature().isElementPresent(2), "New Feature Tab in home page is not Present");
        String url = homePage.getHeader().getNewFeature().getAttribute("href");
        Assert.assertTrue(!url.isEmpty(), "Url is empty");
        getDriver().switchTo().newWindow(WindowType.TAB).get(url);
        Assert.assertTrue(getDriver().getCurrentUrl().equals(homePage.getHeader().getNewFeature().getAttribute("href")), "Both the links are different");
        homePage.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

//    @Test(description = "Verify Help options", dataProvider = "validHelpOptions")
//    public void verifyHelpTest(String options) {
//        HelpPage helpPage = new HelpPage(getDriver());
//        helpPage.open();
//        Assert.assertTrue(helpPage.getSearchBox().isElementPresent(1), "Search box in Help page is not Present");
//        Assert.assertTrue(options.matches("^[a-zA-Z&\\s-]+$"), "Options are not in the correct format");
//        helpPage.typeHelpText(options);
//        Assert.assertTrue(helpPage.getSearchButton().isElementPresent(1), "Search Button in help page is not present");
//        helpPage.clickHelpButton();
//    }

    //    MyListener obj = new MyListener();
    @Test //5. task
    public void listOutSaleItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        String shoe = "Air";
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getNewFeature().isElementPresent(2), "New Feature tab in home page is not present");
        header.clickFeature();
        Assert.assertTrue(shoe.matches("^[a-zA-Z&\\s-]+$"), "shoe name is not in the correct format");
        JavascriptExecutor js = (JavascriptExecutor) homePage.getDriver();
        js.executeScript("scroll(0, 500);");//
        homePage.getItemList().stream()
                .filter(productItem -> productItem.productText().contains(shoe))
                .forEach(productItem ->
                {
                    Actions actions = new Actions(getDriver());
                    actions.moveToElement(productItem.getProductName().getElement()).build().perform();
                });
    }
}

