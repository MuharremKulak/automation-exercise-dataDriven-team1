package com.academy.techcenture.TestCase26;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyScrollDownAndScrollUpFunctionalityTest extends BaseTest {

    private HomePage homePage;


    @Test
    public void VerifyScrollDownAndScrollUpFunctionalityPositiveTest() throws InterruptedException {

        extentTest = extentReports.startTest("VerifyScrollDownAndScrollUpFunctionality");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified Home page title");
        homePage.scrollDownToSubscription();
        extentTest.log(LogStatus.INFO, "Scrolled down to subscription web element");
        homePage.verifySubscriptionHeader();
        extentTest.log(LogStatus.INFO, "Verified subscription header");
        homePage.scrollUpToTheTopOfPage();
        extentTest.log(LogStatus.INFO, "Scrolled Up to all the way top of the page");
        homePage.verifyFullFledgedPracticeTextIsVisible();
    }
}
