package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.Menu;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NavigateToLabels extends AbstractTest {

    @Test//7.Task
    public void verifyNavigateForMenTab() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.getHeader().getMen().isElementPresent(2), "Men Tab is not Present in the Header");
        homePage.getHeader().clickMen();
        MenPage menPage = new MenPage(getDriver());
        String option = Menu.SALE.getOptionName();
        Assert.assertNotNull(option, "Label Option Not found");
        Assert.assertTrue(option.matches("^[a-zA-Z\\s-]+$"), "Label Option is not in the correct format");
        menPage.getLabels().stream()
                .filter(extendedWebElement ->
                        extendedWebElement.getAttribute("aria-label").equalsIgnoreCase(option))
                .findAny()
                .ifPresent(extendedWebElement -> {
                            String url = extendedWebElement.getAttribute("href");
                            getDriver().switchTo().newWindow(WindowType.TAB).get(url);
                        }
                );
    }
}
