package com.solvd.testautomation.ui;

import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class FrameHomePagePracticeTest extends AbstractTest {

    @Test
    public void FrameTest(){
        FrameHomePage frameHomePage = new FrameHomePage(getDriver());
        frameHomePage.open();
        Frame1 frame1 = new Frame1(getDriver());
        getDriver().switchTo().frame(frameHomePage.getFrame1().getElement());
        frame1.clickDropDownBox();
        getDriver().switchTo().defaultContent();
        Frame2 frame2 = new Frame2(getDriver());
        getDriver().switchTo().frame(frameHomePage.getFrame2().getElement());
        frame2.clickFirstname();
        frame2.typeFirstName("Jack");
        frame2.clickLastname();
        frame2.typeLastName("Bob");
        String genderOption = "male";
        frame2.clickGenderOption(genderOption);
        String language = "English";
        frame2.clickLanguageOption(language);
        frame2.clickEmail();
        frame2.typeEmailId("jack@gmail.com");
        getDriver().switchTo().defaultContent();
    }
}
