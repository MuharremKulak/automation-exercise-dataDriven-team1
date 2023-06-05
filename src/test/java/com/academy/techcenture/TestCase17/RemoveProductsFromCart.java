package com.academy.techcenture.TestCase17;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;
import com.academy.techcenture.baseTest.BaseTest;

public class RemoveProductsFromCart extends BaseTest {

    private HomePage homePage;
    private PlaceOrderPage placeOrderPage;
    private LoginPage loginPage;
    private ShoppingCartPage shoppingCartPage;

    @Test
    public void RemoveProductsFromCartTest() throws InterruptedException {

        extentTest = extentReports.startTest("PlaceAnOrderLoginBeforeCheckoutPositiveTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Login page");
        placeOrderPage = new PlaceOrderPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Place Order page");
        shoppingCartPage = new ShoppingCartPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Shopping Cart Page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified Home page title");
        placeOrderPage.clickOnAddToCartBtn();
        extentTest.log(LogStatus.PASS, "Clicked on add to cart button");
        placeOrderPage.verifyAddedToCartMsg();
        extentTest.log(LogStatus.INFO, "Verified added to cart message");
        shoppingCartPage.clickViewCart();
        extentTest.log(LogStatus.INFO, "Verified item is removed from the cart button after the message");
        shoppingCartPage.clickRemoveItemFromTheCart();
        extentTest.log(LogStatus.INFO, "Verified item is removed from the cart");
        shoppingCartPage.verifyCartIsEmptyMsgIsDisplayed();
        extentTest.log(LogStatus.INFO, "Verified Cart is empty! message is displayed");
    }
}
