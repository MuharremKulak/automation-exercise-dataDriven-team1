package com.academy.techcenture.TestCase11;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.CartSubsPage;
import com.academy.techcenture.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifySubscriptionInCartPageTest extends BaseTest {

    private HomePage homePage;
    private CartSubsPage cartSubsPage;

    @Test(dataProvider = "CustomerAccountInformation")
    public void VerifySubscriptionPageTest(Map<String, String> data) throws InterruptedException {

        extentTest= extentReports.startTest("VerifySubscriptionPageTest");

        homePage= new HomePage(driver);
        extentTest.log(LogStatus.INFO,"Instantiated new Home Page");
        cartSubsPage = new CartSubsPage(driver);
        extentTest.log(LogStatus.INFO,"Instantiated new Cart Subs Page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO,"Navigated Home Page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS,"Verified title");
        cartSubsPage.navigateToCartPage();
        homePage.scrollDownToSubscription();
        cartSubsPage.verifySubscriptionHomePage();
        extentTest.log(LogStatus.PASS,"Verified title Subs");
        cartSubsPage.enterEmailForSubs(data);
        extentTest.log(LogStatus.INFO, "Email is entered successfully");
        cartSubsPage.clickSubsButton();
        extentTest.log(LogStatus.PASS,"Clicked on Subs Button");
        cartSubsPage.verifySubsMessage();
        extentTest.log(LogStatus.INFO,"The message displayed successfully");

    }
}