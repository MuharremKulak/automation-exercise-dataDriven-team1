package com.academy.techcenture.TestCase15;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class PlaceOrderRegisterBeforeCheckout extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private EnterAccountInformationPage enterAccountInformationPage;
    private AccountCreatedPage accountCreatedPage;
    private AllProductPage allProductPage;
    private ShoppingCartPage shoppingCartPage;
    private PlaceOrderPage placeOrderPage;
    private PaymentPage paymentPage;
    private AccountDeletedPage accountDeletedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void PlaceOrderRegisterBeforeCheckoutTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("PlaceOrderRegisterBeforeCheckout");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Login page");
        enterAccountInformationPage = new EnterAccountInformationPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Enter Account Information page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Account Created Page");
        allProductPage = new AllProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated All Product Page");
        shoppingCartPage = new ShoppingCartPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated shopping cart Page");
        placeOrderPage = new PlaceOrderPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated place order Page");
        paymentPage = new PaymentPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated payment Page");
        accountDeletedPage = new AccountDeletedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated account deleted Page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Home Page Title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on signUp/Login button");
        loginPage.enterNameForSignUp(data);
        extentTest.log(LogStatus.PASS, "Entered name for SignUp");
        loginPage.enterEmailForSignUp(data);
        extentTest.log(LogStatus.PASS, "Entered email for SignUp");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked SignUp button");
        enterAccountInformationPage.mrOrMrsRadioButton(data);
        extentTest.log(LogStatus.PASS, "Chosen gender for user");
        enterAccountInformationPage.fillAccountDetails(data);
        extentTest.log(LogStatus.PASS, "Entered information about user");
        enterAccountInformationPage.selectNewsletterOffers();
        extentTest.log(LogStatus.PASS, "Selected newsletters offers");
        enterAccountInformationPage.fillAddressDetails(data);
        extentTest.log(LogStatus.PASS, "Entered information about user");
        enterAccountInformationPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked create account button");
        accountCreatedPage.accountCreatedConfirmHeader();
        extentTest.log(LogStatus.PASS, "Verified account created confirm header");
        accountCreatedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked continue button");
        loginPage.verifyLoginAsUsername();
        extentTest.log(LogStatus.PASS, "Verified login as username");
        allProductPage.hoverOverFirstProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover First Product and Added to Cart");
        allProductPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        shoppingCartPage.verifyCartPage();
        extentTest.log(LogStatus.PASS, "Verified cart page");
        shoppingCartPage.clickProceedToCheckoutButton();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout button");
        placeOrderPage.verifyDeliveryAddressToOriginalInput(data);
        extentTest.log(LogStatus.PASS, "Verified delivery address to original input");
        placeOrderPage.enterCommentInTable();
        extentTest.log(LogStatus.PASS, "Entered comment in table");
        placeOrderPage.clickOnPlaceAnOrderButton();
        extentTest.log(LogStatus.PASS, "Clicked place order button");
        paymentPage.fillOutPaymentInformation(data);
        extentTest.log(LogStatus.PASS, "Filled it out information about user");
        paymentPage.verifySuccessfulMessage();
        extentTest.log(LogStatus.PASS, "Verified success message");
        paymentPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked delete account button");
        accountDeletedPage.verifyAccountDeletedHeader();
        extentTest.log(LogStatus.PASS, "Verified account deleted header");
        accountDeletedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked continue button");
    }
}
