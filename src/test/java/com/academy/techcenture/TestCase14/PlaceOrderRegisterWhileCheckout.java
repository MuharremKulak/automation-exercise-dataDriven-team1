package com.academy.techcenture.TestCase14;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class PlaceOrderRegisterWhileCheckout extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductDetailPage productDetailPage;
    private AllProductPage allProductPage;
    private ShoppingCartPage shoppingCartPage;
    private EnterAccountInformationPage enterAccountInformationPage;
    private AccountCreatedPage accountCreatedPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private AccountDeletedPage accountDeletedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void PlaceOrderRegisterWhileCheckoutTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("PlaceOrderRegisterWhileCheckout");

        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated product details page");
        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Home Page Title");
        homePage.clickProductsButton();
        allProductPage = new AllProductPage(driver);
        allProductPage.hoverOverFirstProductAndClickAddToCart();
        allProductPage.clickOnContinueShoppingButton();
        allProductPage.hoverOverSecondProductAndClickAddToCart();
        allProductPage.clickOnViewCartButton();
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.verifyCartPage();
        shoppingCartPage.clickProceedToCheckoutButton();
        shoppingCartPage.clickOnRegisterLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.fillAllDetailsInSignUp(data);
        enterAccountInformationPage = new EnterAccountInformationPage(driver);
        enterAccountInformationPage.verifyEnterAccountInfoHeader();
        enterAccountInformationPage.mrOrMrsRadioButton(data);
        enterAccountInformationPage.fillAccountDetails(data);
        enterAccountInformationPage.selectNewsletterOffers();
        enterAccountInformationPage.fillAddressDetails(data);
        enterAccountInformationPage.clickCreateAccountButton();
        accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.accountCreatedConfirmHeader();
        accountCreatedPage.clickContinueButton();
        loginPage.verifyLoginAsUsername();
        homePage.clickOnCartButton();
        shoppingCartPage.clickProceedToCheckoutButton();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.verifyHeadersAtCheckOutPage();
        checkoutPage.scrollAllTheWayDownToPage();
        checkoutPage.enterCommentAndClickPlaceOrder();
        paymentPage = new PaymentPage(driver);
        paymentPage.fillOutPaymentInformation(data);
        paymentPage.verifySuccessfulMessage();
        paymentPage.clickOnDeleteAccountButton();
        accountDeletedPage = new AccountDeletedPage(driver);
        accountDeletedPage.verifyAccountDeletedHeader();
        accountDeletedPage.clickContinueButton();
    }

}