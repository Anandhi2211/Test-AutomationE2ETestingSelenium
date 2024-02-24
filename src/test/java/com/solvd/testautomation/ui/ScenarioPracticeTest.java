package com.solvd.testautomation.ui;

import com.zebrunner.carina.core.AbstractTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScenarioPracticeTest extends AbstractTest {


    @Test
    public void validateDropDownTest() {
        ScenarioPractice scenarioPractice = new ScenarioPractice(getDriver());
        scenarioPractice.open();
        scenarioPractice.clickDropDownOption();
        scenarioPractice.getOptionList().stream()
                .filter(extendedWebElement -> extendedWebElement.getAttribute("value").startsWith("Z"))
                .forEach(extendedWebElement ->
                        {
                            extendedWebElement.click();
                            Select select = new Select(scenarioPractice.getDropDown().getElement());
                            String name = select.getFirstSelectedOption().getText().trim();
                            System.out.println(name);//Add assert Operations
                            this.takeSnapShot(getDriver()) ;
                        }
                );
    }

    private void takeSnapShot(WebDriver driver) {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("C://Users//anand//OneDrive//Desktop//Anandhi_Learning//QA Training//Solvd//Test Automation//Screenshot//test.png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

