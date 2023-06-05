package com.academy.techcenture.TestCase10;


import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.SubscriptionPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifySubscriptionInHomePageTest extends BaseTest {
    private HomePage homePage;
    private SubscriptionPage subscriptionPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void VerifySubscriptionPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("VerifySubscriptionInHomePageTest");

        homePage = new HomePage(driver);
        subscriptionPage = new SubscriptionPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home Page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page");
        subscriptionPage.verifyHomePageVisible();
        extentTest.log(LogStatus.PASS, "Verified title");

        //To-do Scroll down method
        homePage.scrollDownToSubscription();

        subscriptionPage.verifySubscriptionHomePage();
        extentTest.log(LogStatus.PASS, "Verified title Subs");
        subscriptionPage.enterEmailForSubs(data);
        extentTest.log(LogStatus.INFO, "Email is entered successfully");
        subscriptionPage.clickSubsButton();
        extentTest.log(LogStatus.PASS, "Clicked on Subs Button");
        subscriptionPage.verifySubsMessage();
        extentTest.log(LogStatus.INFO, "The message displayed successfully");

    }
}