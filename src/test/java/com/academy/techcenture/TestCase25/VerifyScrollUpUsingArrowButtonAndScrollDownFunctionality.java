package com.academy.techcenture.TestCase25;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.PlaceOrderPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality extends BaseTest {

    private HomePage homePage;
    private PlaceOrderPage placeOrderPage;
    private LoginPage loginPage;

    @Test
    public void VerifyScrollUpUsingArrowButtonAndScrollDownFunctTest() throws InterruptedException {

        extentTest = extentReports.startTest("PlaceAnOrderLoginBeforeCheckoutPositiveTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Login page");
        placeOrderPage = new PlaceOrderPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Place Order page");


        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified Home page title");
        homePage.scrollDownToSubscription();
        extentTest.log(LogStatus.INFO, "Scrolled down to subscription text");
        homePage.verifySubscriptionTextIsVisible();
        extentTest.log(LogStatus.INFO, "Verified subscription text is visible");
        homePage.clickOnScrollUpArrow();
        extentTest.log(LogStatus.INFO, "Scrolled up the arrow to the top of home page");
        homePage.verifyFullFledgedPracticeTextIsVisible();
        extentTest.log(LogStatus.INFO, "Verified  'Full-Fledged practice website for Automation Engineers' text is visible ");
    }
}

