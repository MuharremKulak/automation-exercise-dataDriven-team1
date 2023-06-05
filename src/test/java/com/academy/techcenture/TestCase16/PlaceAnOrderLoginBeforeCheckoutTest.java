package com.academy.techcenture.TestCase16;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class PlaceAnOrderLoginBeforeCheckoutTest extends BaseTest {

    private HomePage homePage;
    private PlaceOrderPage placeOrderPage;
    private LoginPage loginPage;
    private PaymentPage paymentPage;
    private AccountDeletedPage accountDeletedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void PlaceAnOrderLoginBeforeCheckoutPositiveTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("PlaceAnOrderLoginBeforeCheckoutPositiveTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Login page");
        placeOrderPage = new PlaceOrderPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Place Order page");
        paymentPage = new PaymentPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Payment page");
        accountDeletedPage = new AccountDeletedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Account Deleted page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified Home page title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on signUp/Login Button");
        loginPage.verifyLoginToYourAccountHeader();
        extentTest.log(LogStatus.INFO, "Verified Login to Your account header");
        loginPage.enterCustomerEmailForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered customer email for login");
        loginPage.enterCustomerPasswordForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered customer password for login");
        loginPage.clickOnLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on login button");
        loginPage.verifyLoginAsUsername();
        extentTest.log(LogStatus.INFO, "Verified login as username");
        placeOrderPage.clickOnAddToCartBtn();
        extentTest.log(LogStatus.PASS, "Clicked on add to cart button");
        placeOrderPage.verifyAddedToCartMsg();
        extentTest.log(LogStatus.INFO, "Verified added to cart message");
        placeOrderPage.clickOnViewCartToProceedToCheckOut();
        extentTest.log(LogStatus.PASS, "Clicked on view cart to proceed to checkout");
        placeOrderPage.clickOnProceedToCheckOut();
        extentTest.log(LogStatus.PASS, "Clicked on proceed to checkout");
        placeOrderPage.verifyDeliveryAddressToOriginalInput(data);
        extentTest.log(LogStatus.PASS, "Verified delivery address to original input");
        placeOrderPage.enterCommentInTable();
        extentTest.log(LogStatus.PASS, "Entered comment in the table box");
        placeOrderPage.clickOnPlaceAnOrderButton();
        extentTest.log(LogStatus.PASS, "Clicked on place an order button");
        paymentPage.fillOutPaymentInformation(data);
        extentTest.log(LogStatus.PASS, "Entered customer payment information");
        paymentPage.verifySuccessfulMessage();
        extentTest.log(LogStatus.INFO, "Verified successful message");
        paymentPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on Delete Account button");
        accountDeletedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked continue button");
    }
}