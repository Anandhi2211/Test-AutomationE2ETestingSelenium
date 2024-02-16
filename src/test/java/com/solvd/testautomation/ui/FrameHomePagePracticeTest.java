package com.solvd.testautomation.ui;

import com.solvd.testautomation.ui.components.frames.Frame1;
import com.solvd.testautomation.ui.components.frames.Frame2;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FrameHomePagePracticeTest extends AbstractTest {

    @Test//3. task
    public void FrameTest(){
        FrameHomePage frameHomePage = new FrameHomePage(getDriver());
        frameHomePage.open();
        SoftAssert softAssert = new SoftAssert();
        Frame1 frame1 = new Frame1(getDriver());
        getDriver().switchTo().frame(frameHomePage.getFrame1().getElement());
        Assert.assertTrue(frame1.getDropDownBox().isElementPresent(2),"DropDownBox Element is not present");
        frame1.clickDropDownBox();
        getDriver().switchTo().defaultContent();
        Frame2 frame2 = new Frame2(getDriver());
        getDriver().switchTo().frame(frameHomePage.getFrame2().getElement());
        Assert.assertTrue(frame2.getFirstName().isElementPresent(2),"First Name TextBox Element is not Present");
        frame2.clickFirstname();
        String firstName = "Jack";
        softAssert.assertTrue(firstName.matches("^[a-zA-Z@\\s-]+$"),"First Name doesn't match the Format");
        frame2.typeFirstName(firstName);
        Assert.assertTrue(frame2.getLastName().isElementPresent(2),"Last Name TextBox Element is not Present");
        frame2.clickLastname();
        String lastName = "Bob";
        softAssert.assertTrue(lastName.matches("^[a-zA-Z@\\s-]+$"),"Last Name doesn't match the format");
        frame2.typeLastName(lastName);
        String gender = "male";
        softAssert.assertTrue(gender.matches("^[a-zA-Z@\\s-]+$"),"gender option doesn't match the format");
        frame2.clickGenderOption(gender);
        String language = "English";
        frame2.clickLanguageOption(language);
        Assert.assertTrue(frame2.getEmail().isElementPresent(2),"Email TextBox Element is not Present");
        frame2.clickEmail();
        String email = "jack@gmail.com";
        frame2.typeEmailId(email);
        getDriver().switchTo().defaultContent();
    }
}
