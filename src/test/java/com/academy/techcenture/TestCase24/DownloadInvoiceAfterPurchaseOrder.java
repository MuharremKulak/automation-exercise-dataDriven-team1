package com.academy.techcenture.TestCase24;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class DownloadInvoiceAfterPurchaseOrder extends BaseTest {

    private HomePage homePage;
    private AllProductPage allProductPage;
    private LoginPage loginPage;
    private ShoppingCartPage shoppingCartPage;
    private EnterAccountInformationPage enterAccountInformationPage;
    private AccountCreatedPage accountCreatedPage;
    private CheckoutPage checkoutPage;
    private PlaceOrderPage placeOrderPage;
    private PaymentPage paymentPage;
    private AccountDeletedPage accountDeletedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void DownloadInvoiceAfterPurchaseOrderTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("VerifyAddressDetailsInCheckoutPageTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductPage = new AllProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all product page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all login page");
        shoppingCartPage = new ShoppingCartPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated shopping cart page");
        enterAccountInformationPage = new EnterAccountInformationPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Enter Account Information page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Enter Account Created page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated checkout page");
        placeOrderPage = new PlaceOrderPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Place Order page");
        paymentPage = new PaymentPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Payment page");
        accountDeletedPage = new AccountDeletedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Account Deleted page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified Home Page title");
        allProductPage.hoverOverFirstProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hovered over first product and clicked add to cart");
        allProductPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        shoppingCartPage.verifyCartPage();
        extentTest.log(LogStatus.INFO, "Verified cart page");
        shoppingCartPage.clickProceedToCheckoutButton();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout button");
        shoppingCartPage.clickOnRegisterLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on register login button");
        loginPage.enterNameForSignUp(data);
        extentTest.log(LogStatus.PASS, "Entered name for signUp");
        loginPage.enterEmailForSignUp(data);
        extentTest.log(LogStatus.PASS, "Entered email for signUp");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked on signUp button");
        enterAccountInformationPage.mrOrMrsRadioButton(data);
        extentTest.log(LogStatus.PASS, "Chosen gender");
        enterAccountInformationPage.fillAccountDetails(data);
        extentTest.log(LogStatus.PASS, "Entered account details");
        enterAccountInformationPage.selectNewsletterOffers();
        extentTest.log(LogStatus.PASS, "Selected newsletter offers");
        enterAccountInformationPage.fillAddressDetails(data);
        extentTest.log(LogStatus.PASS, "Entered name for signUp");
        enterAccountInformationPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked create account button");
        accountCreatedPage.accountCreatedConfirmHeader();
        extentTest.log(LogStatus.INFO, "Verified account created header");
        accountCreatedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked continue button");
        loginPage.verifyLoginAsUsername();
        extentTest.log(LogStatus.INFO, "Verified Login as username");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on cart button");
        shoppingCartPage.clickProceedToCheckoutButton();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout button");
        placeOrderPage.verifyDeliveryAddressToOriginalInput(data);
        extentTest.log(LogStatus.INFO, "Verified Home Page title");
        placeOrderPage.enterCommentInTable();
        extentTest.log(LogStatus.PASS, "Entered comment in table");
        placeOrderPage.clickOnPlaceAnOrderButton();
        extentTest.log(LogStatus.PASS, "Clicked on place an order button");
        paymentPage.fillOutPaymentInformation(data);
        extentTest.log(LogStatus.PASS, "Filled out payment information");
        paymentPage.verifySuccessfulMessage();
        extentTest.log(LogStatus.INFO, "Verified successful message");
        placeOrderPage.downloadInvoice();
        extentTest.log(LogStatus.PASS, "Downloaded Invoice successfully.");
        placeOrderPage.verifyInvoiceIsDownloaded();
        extentTest.log(LogStatus.INFO, "Verified invoice is downloaded successfully.");
        placeOrderPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
        loginPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on delete account button");
        accountDeletedPage.verifyAccountDeletedHeader();
        extentTest.log(LogStatus.INFO, "Verified account deleted header");
        accountDeletedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
    }

}